package iut.uca.twibook.controller;

import iut.uca.twibook.Status;
import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.mappers.UserMapper;
import iut.uca.twibook.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;



@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

	@GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(mapper.toDTO(userService.findById(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(@RequestParam(required = false) String nickName) {

        if(nickName != null) {
            return new ResponseEntity<>(mapper.toListDTO(Collections.singletonList(userService.findByNickName(nickName))), HttpStatus.OK);
        }

        List<UserDTO> userDTOList = mapper.toListDTO(userService.getUsers());

        if(userDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO user) {
        user.setId((new ObjectId()).toString());
        Status response = userService.createUser(mapper.toEntity(user));

        switch (response) {
            case UPDATED: return new ResponseEntity<>("User updated", HttpStatus.OK);

            default: return new ResponseEntity<>("User created", HttpStatus.CREATED);
        }
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ObjectId id) {
        if(userService.deleteUser(id) == 1){
            return new ResponseEntity<>("User deleted", HttpStatus.OK);
        }
        return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
    }
}

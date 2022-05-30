package iut.uca.twibook.controller;

import iut.uca.twibook.Status;
import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.entities.UserEntity;
import iut.uca.twibook.factories.UserFactory;
import iut.uca.twibook.mappers.UserMapper;
import iut.uca.twibook.repositories.UserRepository;
import iut.uca.twibook.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    private final UserMapper mapper = UserMapper.INSTANCE;

	@GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(mapper.toDTO(userService.findById(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers() {
        List<UserEntity> userEntities = userService.getUsers();

        if(userEntities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userEntities, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserEntity user) {

        Status response = userService.createUser(user);

        switch (response) {
            case UPDATED: return new ResponseEntity<>("User updated", HttpStatus.OK);

            default: return new ResponseEntity<>("User created", HttpStatus.CREATED);
        }
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ObjectId id) {
        if(userService.deleteTire(id) == 1){
            return new ResponseEntity<>("Tire deleted", HttpStatus.OK);
        }
        return new ResponseEntity("Tire not found", HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        repository.deleteById(id.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

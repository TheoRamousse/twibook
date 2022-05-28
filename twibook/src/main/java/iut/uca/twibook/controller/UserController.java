package iut.uca.twibook.controller;

import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.entities.UserEntity;
import iut.uca.twibook.repositories.UserRepository;
import iut.uca.twibook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
	@Autowired
	private UserRepository repository;

    @Autowired
    private UserService userService;

    /*
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        Optional<UserEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            return new ResponseEntity<>(UserFactory.createDTO(entity.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     */

    /*
    @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<UserDTO> find(@PathVariable UserDTO user) {
        Optional<UserEntity> entity = repository.findById(user.getId());

        if (entity.isPresent()) {
            return new ResponseEntity<>(UserFactory.createDTO(entity.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     */

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> findUsers() {
        return new ResponseEntity<>(userService.findUsers(), HttpStatus.OK);
    }
}

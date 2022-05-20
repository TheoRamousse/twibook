package iut.uca.twibook.controller;

import java.util.Optional;

import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.factories.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import iut.uca.twibook.entities.UserEntity;
import iut.uca.twibook.repositories.UserRepository;


@CrossOrigin(origins = "*")
@RestController
//@ExposesResourceFor(User.class)
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {
	@Autowired
	private UserRepository repository;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        Optional<UserEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            return new ResponseEntity<>(UserFactory.CreateDTO(entity.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<UserDTO> find(@PathVariable UserDTO user) {
        Optional<UserEntity> entity = repository.findById(user.getId());

        if (entity.isPresent()) {
            return new ResponseEntity<>(UserFactory.CreateDTO(entity.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO user) {
        UserEntity createdEntity = repository.save(UserFactory.CreateEntity(user));
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }
}

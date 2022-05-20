package iut.uca.twibook.controller;

import java.util.Optional;

import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.factories.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}

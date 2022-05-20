package iut.uca.twibook.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import iut.uca.twibook.dtos.CommentDTO;
import iut.uca.twibook.entities.CommentEntity;
import iut.uca.twibook.factories.CommentFactory;
import iut.uca.twibook.repositories.CommentRepository;
import iut.uca.twibook.services.CommentService;

@Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/comment", produces = "application/json")
public class CommentController {

	@Autowired
	CommentService service;
	
	@Autowired
	CommentRepository repository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CommentDTO> findById(@PathVariable String id) {
        Optional<CommentEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            return new ResponseEntity<>(CommentFactory.CreateDTO(entity.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<CommentDTO> find(@PathVariable CommentDTO user) {
        Optional<CommentEntity> entity = repository.findById(user.getId());

        if (entity.isPresent()) {
            return new ResponseEntity<>(CommentFactory.CreateDTO(entity.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<CommentEntity> createUser(@RequestBody CommentDTO user) {
        CommentEntity createdEntity = repository.save(CommentFactory.CreateEntity(user));
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }
	
}

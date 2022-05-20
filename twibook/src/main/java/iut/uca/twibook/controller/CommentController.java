package iut.uca.twibook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import iut.uca.twibook.dtos.CommentDTO;
import iut.uca.twibook.entities.CommentEntity;
import iut.uca.twibook.factories.CommentFactory;
import iut.uca.twibook.repositories.CommentRepository;
import iut.uca.twibook.services.CommentService;


@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping(value = "/comments")
public class CommentController {

	@Autowired
	CommentService service;
	
	@Autowired
	CommentRepository repository;

	@GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable String id) {
        Optional<CommentEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            return new ResponseEntity<>(CommentFactory.createDTO(entity.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@GetMapping
    public ResponseEntity<List<CommentEntity>> getComments() {

        List<CommentEntity> commentEntities = repository.findAll();

        if (commentEntities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(commentEntities, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<CommentEntity> createComment(@RequestBody CommentDTO user) {
        CommentEntity createdEntity = repository.save(CommentFactory.createEntity(user));
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        repository.deleteById(id.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

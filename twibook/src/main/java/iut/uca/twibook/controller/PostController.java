package iut.uca.twibook.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import iut.uca.twibook.dtos.PostDTO;
import iut.uca.twibook.entities.PostEntity;
import iut.uca.twibook.factories.PostFactory;
import iut.uca.twibook.repositories.PostRepository;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping(value = "/post", produces = "application/json")
public class PostController {
	@Autowired
	PostRepository repository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        Optional<PostEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            return new ResponseEntity<>(PostFactory.createDTO(entity.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<PostDTO> find(@PathVariable PostDTO post) {
        Optional<PostEntity> entity = repository.findById(post.getId());

        if (entity.isPresent()) {
            return new ResponseEntity<>(PostFactory.createDTO(entity.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<PostEntity> createPost(@RequestBody PostDTO post) {
        PostEntity createdEntity = repository.save(PostFactory.createEntity(post));
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        repository.deleteById(id.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

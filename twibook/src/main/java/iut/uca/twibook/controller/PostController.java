package iut.uca.twibook.controller;

import java.util.List;
import java.util.Optional;

import iut.uca.twibook.entities.CommentEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import iut.uca.twibook.dtos.PostDTO;
import iut.uca.twibook.entities.PostEntity;
import iut.uca.twibook.factories.PostFactory;
import iut.uca.twibook.repositories.PostRepository;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping(value = "/posts")
public class PostController {
	@Autowired
	PostRepository repository;

	@GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        Optional<PostEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            return new ResponseEntity<>(PostFactory.createDTO(entity.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PostEntity> createPost(@RequestBody PostDTO post) {
        PostEntity entity = PostFactory.createEntity(post);
        entity.setId(new ObjectId());
        PostEntity createdEntity = repository.save(entity);
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        repository.deleteById(id.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostEntity>> getPostsPagined(@RequestParam(required = false) Integer nbElementsPerPage, @RequestParam(required = false) Integer page) {

        Page<PostEntity> postEntities = repository.findAll(PageRequest.of(page, nbElementsPerPage));

        if (postEntities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(postEntities.getContent(), HttpStatus.OK);
        }
    }




}

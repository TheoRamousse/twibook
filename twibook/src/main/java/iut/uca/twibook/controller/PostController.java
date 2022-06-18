package iut.uca.twibook.controller;

import java.util.List;

import iut.uca.twibook.Status;
import iut.uca.twibook.dtos.PostDTO;
import iut.uca.twibook.mappers.PostMapper;
import iut.uca.twibook.services.PostService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import iut.uca.twibook.dtos.PostDTO;

@RestController
@CrossOrigin
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    PostMapper mapper;

	@GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable ObjectId id) {

        return new ResponseEntity<>(mapper.toDTO(postService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDTO post) {
        if(post.getId() == null || post.getId() == "0") {
            post.setId(new ObjectId().toString());
        }
        Status response = postService.createPost(mapper.toEntity(post));

        switch (response) {
            case UPDATED: return new ResponseEntity<>("Post updated", HttpStatus.OK);

            default: return new ResponseEntity<>("Post created", HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePost(@PathVariable ObjectId id) {
        if(postService.deletePost(id) == 1){
            return new ResponseEntity<>("Post deleted", HttpStatus.OK);
        }
        return new ResponseEntity("Post not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getPostsPagined(@RequestParam(required = false) Integer nbElementsPerPage, @RequestParam(required = false) Integer page) {

        List<PostDTO> postDTOList;

        if(nbElementsPerPage != null && page != null){
            postDTOList = mapper.toListDTO(postService.findAllPagined(page, nbElementsPerPage));
        }
        else {
            postDTOList = mapper.toListDTO(postService.getPosts());
        }

        if (postDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(postDTOList, HttpStatus.OK);
        }
    }
}

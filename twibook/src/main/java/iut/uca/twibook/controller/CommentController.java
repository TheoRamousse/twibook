package iut.uca.twibook.controller;

import iut.uca.twibook.Status;
import iut.uca.twibook.dtos.CommentDTO;
import iut.uca.twibook.mappers.CommentMapper;
import iut.uca.twibook.services.CommentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentMapper mapper;

	@GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(mapper.toDTO(commentService.findById(id)), HttpStatus.OK);
    }


	@GetMapping
    public ResponseEntity<List<CommentDTO>> getComments() {

        List<CommentDTO> commentDTOList = mapper.toListDTO(commentService.getComments());

        if (commentDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<String> createComment(@RequestBody CommentDTO comment) {
        Status response = commentService.createComment(mapper.toEntity(comment));

        switch (response) {
            case UPDATED: return new ResponseEntity<>("Comment updated", HttpStatus.OK);

            default: return new ResponseEntity<>("Comment created", HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable ObjectId id) {
        if(commentService.deleteComment(id) == 1){
            return new ResponseEntity<>("Comment deleted", HttpStatus.OK);
        }
        return new ResponseEntity("Comment not found", HttpStatus.NOT_FOUND);
    }

}

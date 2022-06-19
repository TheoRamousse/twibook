package iut.uca.twibook.controller;

import iut.uca.twibook.Status;
import iut.uca.twibook.dtos.CommentDTO;
import iut.uca.twibook.entities.comment_entities.CommentEntityV2;
import iut.uca.twibook.mappers.CommentMapper;
import iut.uca.twibook.services.CommentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import iut.uca.twibook.dtos.CommentDTO;
import java.util.List;


@RestController
@CrossOrigin
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

        List<CommentDTO> commentDTOList = mapper.toListDTOwithV2(commentService.getComments());

        if (commentDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO comment) {
        comment.setId(new ObjectId().toString());

        CommentService.EntityAndCodeResult response = commentService.createComment(mapper.toEntityV2(comment));

        switch (response.getStatus()) {
            case UPDATED: return new ResponseEntity<>(mapper.toDTO(response.getEntity()), HttpStatus.OK);

            default: return new ResponseEntity<>(mapper.toDTO(response.getEntity()), HttpStatus.CREATED);
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

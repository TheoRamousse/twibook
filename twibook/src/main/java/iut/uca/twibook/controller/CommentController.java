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

package iut.uca.twibook.controller;

import iut.uca.twibook.dtos.CommentDTO;
import iut.uca.twibook.entities.CommentEntityAndResultCode;
import iut.uca.twibook.entities.PostEntityAndResultCode;
import iut.uca.twibook.mappers.CommentMapper;
import iut.uca.twibook.services.CommentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Ce controller permet de gérer l'ensemble des actions possible sur les commentaires.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentMapper mapper;

    /***
     * Ce endpoint permet de récupérer un commentaire grâce à son Id.
     * @param id L'Id à rechercher dans la base de données.
     * @return Retourne une 200 avec le commentaire dans son intégralité ou une 404 si le commentaire n'a pas été trouvé.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(mapper.toDTO(commentService.findById(id)), HttpStatus.OK);
    }


    /***
     * Ce endpoint permet de récupérer l'ensemble des commentaires présent dans la base de données.
     * @return Retourne une 200 avec l'ensemble des joueurs présent en base ou une 204.
     */
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

    /***
     * Ce endpoint permet d'ajouter un commentaire en base
     * ou de modifier celui présent si un Id est spécifié dans le champ Id du commentaire donné
     * @param comment Le commentaire à ajouter.
     * @return Retourne un message indiquant le status de la création ou de modification.
     */
    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO comment) {
        comment.setId(new ObjectId().toString());

        CommentEntityAndResultCode response = commentService.createComment(mapper.toEntityV2(comment));

        switch (response.getStatus()) {
            case UPDATED: return new ResponseEntity<>(mapper.toDTO(response.getEntity()), HttpStatus.OK);

            default: return new ResponseEntity<>(mapper.toDTO(response.getEntity()), HttpStatus.CREATED);
        }
    }

    /***
     * Ce endpoint permet de supprimer un commentaire à partir d'un Id de commentaire.
     * @param id L'Id du commentaire à supprimer.
     * @return Retourne un message indiquant la bonne suppression du commentaire
     * ou un message indiquant que le commentaire n'a pas été trouvé.
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable ObjectId id) {
        if(commentService.deleteComment(id) == 1){
            return new ResponseEntity<>("Comment deleted", HttpStatus.OK);
        }
        return new ResponseEntity("Comment not found", HttpStatus.NOT_FOUND);
    }

}

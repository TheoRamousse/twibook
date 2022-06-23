package iut.uca.twibook.services;

import iut.uca.twibook.Status;
import iut.uca.twibook.entities.CommentEntityAndResultCode;
import iut.uca.twibook.entities.PostEntityAndResultCode;
import iut.uca.twibook.entities.comment_entities.CommentEntity;
import iut.uca.twibook.entities.comment_entities.CommentEntityV2;
import iut.uca.twibook.mappers.CommentMapper;
import iut.uca.twibook.repositories.comment_repositories.CommentRepository;
import iut.uca.twibook.repositories.comment_repositories.CommentRepositoryV2;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/***
 * Service de commentaire permattant de séparer le traitement métier des couches controller et repository.
 */
@Service
public class CommentService {

    @Autowired
    CommentRepository repository;

    @Autowired
    CommentRepositoryV2 repositoryV2;

    @Autowired
    CommentMapper commentMapper;

    /***
     * Cette méthode permet de récupérer un commentaire à partir de son Id
     * @param id L'Id du commentaire à récupérer.
     * @return Retourne le commentaire dans son intégralité ou renvoie une erreur 404 si le commentaire n'est pas trouvé.
     */
    public CommentEntityV2 findById(ObjectId id){
        CommentEntity commentEntity = repository.findById(id);
        CommentEntityV2 commentEntityV2;

        if(commentEntity != null) {
            commentEntityV2 = commentMapper.toCurrentVersion(commentEntity);
        }
        else {
            commentEntityV2 = repositoryV2.findById(id);
        }

        if(commentEntityV2 == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
        }

        return commentEntityV2;
    }

    /***
     * Cette méthode permet de récupérer l'ensemble des commentaires présents en base.
     * @return Retourne l'ensemble des utilisateurs convertis dans la version la plus recente.
     */
    public List<CommentEntityV2> getComments(){
        List<CommentEntity> commentEntityList = repository.findAll();
        List<CommentEntityV2> commentEntityV2List = repositoryV2.findAll();
        List<CommentEntityV2> temporaryList;

        if(!commentEntityList.isEmpty()) {
            temporaryList = commentMapper.toCurrentVersion(commentEntityList);
            temporaryList.removeAll(commentEntityV2List);
            commentEntityV2List.addAll(temporaryList);
        }

        return commentEntityV2List;
    }

    /***
     * Cette méthode permet d'ajouter ou de modifier un commentaire si l'Id a été renseigné.
     * @param commentEntityV2 Le commentaire à ajouter ou modifier.
     * @return Retourne si le commentaire a été créé ou modifié.
     */
    public CommentEntityAndResultCode createComment(CommentEntityV2 commentEntityV2){
        Status response;

        if(commentEntityV2.getId() != null && repositoryV2.existsById(commentEntityV2.getId().toString())) {
            response = Status.UPDATED;
        }
        else {
            response = Status.CREATED;
            commentEntityV2.setSchemaVersion("2");
        }
        return new CommentEntityAndResultCode(response , repositoryV2.save(commentEntityV2));
    }

    /***
     * Cette méthode permet de supprimer un commentaire à partir de son Id.
     * @param commentToDelete L'Id du commentaire à supprimer.
     * @return Retourne un long indiquant si le commentaire a bien été supprimé ou non.
     */
    public Long deleteComment(ObjectId commentToDelete) {
        return repository.removeById(commentToDelete);
    }

}

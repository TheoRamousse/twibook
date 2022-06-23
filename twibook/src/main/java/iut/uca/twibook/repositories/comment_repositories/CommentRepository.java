package iut.uca.twibook.repositories.comment_repositories;
import iut.uca.twibook.entities.comment_entities.CommentEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/***
 * Repository de commentaire de version ultérieur permettant de contacter la base de données.
 */
@Repository
public interface CommentRepository extends MongoRepository<CommentEntity,String> {

    /***
     * Cette méthode permet de contacter la base et de récupérer un commentaire à partir de son Id.
     * @param id L'Id du commentaire à récupérer.
     * @return Retourne le commentaire dans son intégralité ou null si il n'a pas été trouvé.
     */
    @Query("{ schema_version : '1', _id: ?0}")
    CommentEntity findById(ObjectId id);

    /***
     * Cette méthode permet de contacter la base et de de supprimer un commentaire à partir de son Id.
     * @param _id L'Id du commentaire à supprimer.
     * @return Retourne un long indiquant si la suppréssion s'est faire ou non.
     */
    Long removeById(ObjectId _id);
}


package iut.uca.twibook.repositories.post_entities;

import iut.uca.twibook.entities.post_entities.PostEntity;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/***
 * Repository de post de version ultérieur permettant de contacter la base de données.
 */
@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {

    /***
     * Cette méthode permet de récupérer des post par page.
     * @param pageable Un objet de type Pageable contenant les informations de pagination.
     * @return Retourne un objet de type Page contenant des PostEntity.
     */
    Page<PostEntity> findAll(Pageable pageable);

    /***
     * Cette méthode permet de récupérer un post à partir de Id.
     * @param id L'Id du post à récupérer.
     * @return Retourne le post dans son intégralité ou null si il n'a pas été trouvé.
     */
    @Query("{ schema_version : '1', _id: ?0}")
    PostEntity findById(ObjectId id);

    /***
     * Cette méthode permet de supprimer un post à partir de son Id.
     * @param _id L'Id du post à supprimer.
     * @return Retourne un long indiquant si le post à été supprimé ou non
     */
    Long removeById(ObjectId _id);

    @Aggregation({"{ $match : { publication_date : ?0 } }",
            "{ $group: {_id: publication_date, posts: { $push: $$ROOT} } } }",
            "{ $project: { _id: 0, posts: 1} }"})
    List<PostEntity> groupByPublicationDate(LocalDate localDate);
}


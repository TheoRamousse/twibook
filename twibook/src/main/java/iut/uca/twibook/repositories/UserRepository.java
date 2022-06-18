package iut.uca.twibook.repositories;

import iut.uca.twibook.entities.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/***
 * Repository de user de version ultérieur permettant de contacter la base de données.
 */
@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    /***
     * Cette méthode permet de récupérer un utilisateur à partir de son Id.
     * @param id L'Id de l'utilisateur à récupérer.
     * @return Retourne l'utilisateur dans son intégralité ou null si il n'a pas été trouvé.
     */
    UserEntity findById(ObjectId id);

    /***
     * Cette méthode permet de récupérer un utilisateur à partir de son pseudo.
     * @param email Le pseudo de l'utilisateur à récupérer.
     * @return Retourne l'utilisateur dans son intégralité ou null si il n'a pas été trouvé.
     */
    UserEntity findByNickName(String email);

    /***
     * Cette méthode permet de savoir si un utilisateur est présent en base à partir de son email.
     * @param email L'email de l'utilisateur à rechercher..
     * @return Retourne true si l'utilisateur à été trouvé, sinon false.
     */
    boolean existsByEmail(String email);

    /***
     * Cette méthode permet de récupérer un utilisateur à partir de son email.
     * @param id L'email de l'utilisateur à récupérer.
     * @return Retourne l'utilisateur dans son intégralité ou null si il n'a pas été trouvé.
     */
    UserEntity findByEmail(String id);

    /***
     * Cette méthode permet de supprimer un utilisateur à partir de son Id.
     * @param _id L'Id de l'utilisateur à supprimer.
     * @return  Retourne un long indiquant si l'utilisateur a été supprimer ou non.
     */
    Long removeById(ObjectId _id);
}


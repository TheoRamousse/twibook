package iut.uca.twibook.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

/***
 * Objet utilisateur en retour d'une requète à la base de données.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "twibookUser")
public class UserEntity {

    /***
     * Identifiant de l'utilisateur.
     */
    @Id
    @Field("_id")
    private ObjectId id;

    /***
     * Prenom de l'utilisateur.
     */
    @Field("first_name")
    private String firstName;

    /***
     * Nom de l'utilisateur.
     */
    @Field("last_name")
    private String lastName;

    /***
     * Pseudo de l'utilisateur.
     */
    @Field("nick_name")
    private String nickName;

    /***
     * Image de l'utilisateur.
     */
    @Field("image_url")
    private String imageUrl;

    /***
     * Date de naissance de l'utilisateur.
     */
    @Field("birth_date")
    private LocalDate birthDate;

    /***
     * Email de l'utilisateur.
     */
    @Field("email")
    @Indexed
    private String email;

    /***
     * Mot de passe de l'utilisateur.
     */
    @Field("password")
    private String password;

    /***
     * Liste des Id des posts de l'utilisateur.
     */
    @Field("posts")
    private List<String> posts;

    /***
     * Liste des voitures de l'utilisateur.
     */
    @Field("cars")
    private List<CarEntity> cars;
}

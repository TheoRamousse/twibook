package iut.uca.twibook.entities.post_entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

/***
 * Objet post en retour d'une requète à la base de données.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("post")
public class PostEntityV2 {

    /***
     * Version actuel du schéma.
     */
    public static final String SCHEMA_VERSION = "2";

    /***
     * Identifiant du post.
     */
    @Id
    @Field("_id")
    private ObjectId id;

    /***
     * Texte du post.
     */
    @Field("text")
    private String text;

    /***
     * Image accompagnant le post.
     */
    @Field("post_image")
    private String postImage;

    /***
     * Date de publication du post.
     */
    @Field("publication_date")
    private LocalDate publicationDate;

    /***
     * Texte du premier commentaire.
     */
    @Field("first_comment_text")
    private String firstCommentText;

    /***
     * Image de l'utilisateur ayant posté le premier commentaire.
     */
    @Field("first_comment_user_image_url")
    private String firstCommentUserImageUrl;

    /***
     * Pseudo de l'utilisateur ayant posté le premier commantaire
     */
    @Field("first_comment_user_nick_name")
    private String firstCommentUserNickName;

    /***
     * Liste des Id des commentaires du post.
     */
    @Field("comments")
    private List<String> comments;

    @Field("schema_version")
    private String schemaVersion;
}

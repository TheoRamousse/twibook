package iut.uca.twibook.entities.comment_entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

/***
 * Objet commentaire en retour d'une requète à la base de données.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("comment")
public class CommentEntity {

	/***
	 * Version actuel du schéma.
	 */
	public static final String SCHEMA_VERSION = "1";

	/***
	 * Identifiant du commentaire.
	 */
	@Id
	@Field("_id")
	private ObjectId id;

	/***
	 * Texte du commentaire.
	 */
	@Field("text")
	private String text;

	/***
	 * Date de publication du commentaire.
	 */
	@Field("publication_date")
	private LocalDate publicationDate;

	/***
	 * Pseudo de l'utilisateur ayant posté le commentaire.
	 */
	@Field("user_nick_name")
	private String userNickName;

	/***
	 * Image de l'utilisateur ayant posté le commentaire.
	 */
	@Field("user_image_url")
	private String userImageUrl;

	/***
	 * Version du schéma.
	 */
	@Field("schema_version")
	private String schemaVersion;
}

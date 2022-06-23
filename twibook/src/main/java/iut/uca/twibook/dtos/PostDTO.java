package iut.uca.twibook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


import lombok.Data;
import lombok.experimental.Accessors;

/***
 * Objet post qui sera renvoyé à en retour d'une requète.
 */
@Data
@Accessors
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

	/***
	 * Identifiant du post.
	 */
	private String id;

	/***
	 * Texte du post.
	 */
	private String text;

	/***
	 * Image qui accompagne le post.
	 */
	private String postImage;

	/***
	 * Date de publication du post
	 */
	private LocalDate publicationDate;

	/***
	 * Premier commentaire du post.
	 */
	private String firstCommentText;

	/***
	 * Image de la personne ayant posté le premier commentaire.
	 */
	private String firstCommentUserImageUrl;

	/***
	 * Pseudo de la personne ayant posté le premier commentaire.
	 */
	private String firstCommentUserNickName;

	/***
	 * Liste des identifiants des commentaires du post.
	 */
	private List<String> comments;
	
}

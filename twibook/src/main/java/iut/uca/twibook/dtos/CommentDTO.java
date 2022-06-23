package iut.uca.twibook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/***
 * Objet commentaire qui sera renvoyé en retour d'une requète.
 */
@Data
@Accessors
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    /***
     * Identifiant du commentaire.
     */
	private String id;

    /***
     * Texte du commentaire.
     */
    private String text;

    /***
     * Date de publication du commentaire.
     */
    private LocalDate publicationDate;

    /***
     * Pseudo de l'utilisateur ayant posté le commentaire.
     */
    private String userNickName;

    /***
     * Image de l'utilisateur ayant posté le commentaire.
     */
    private String userImageUrl;
}

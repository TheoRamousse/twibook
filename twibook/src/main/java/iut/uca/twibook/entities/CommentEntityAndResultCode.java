package iut.uca.twibook.entities;

import iut.uca.twibook.Status;
import iut.uca.twibook.entities.comment_entities.CommentEntityV2;
import iut.uca.twibook.entities.post_entities.PostEntityV2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * Cette classe est utilisée pour renvoyer le status du upsert et l'élément qui a été ajouté ou updaté.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntityAndResultCode {

    /***
     * Status de l'upsert
     */
    private Status status;

    /***
     * Element qui a été ajouté ou updaté.
     */
    private CommentEntityV2 entity;
}

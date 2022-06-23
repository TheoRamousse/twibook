package iut.uca.twibook.dtos;

import iut.uca.twibook.entities.enumerations.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

/***
 * Objet voiture qui sera renvoyé en retour d'une requète.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    /***
     * Identifiant de la voiture.
     */
    private ObjectId id;

    /***
     * Modèle de la voiture.
     */
    private String model;

    /***
     * Manufacturié de la voiture.
     */
    private String manufacturer;

    /***
     * Couleur de la voiture.
     */
    private Color color;
}
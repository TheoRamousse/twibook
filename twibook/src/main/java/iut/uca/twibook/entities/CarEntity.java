package iut.uca.twibook.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/***
 * Objet car en retour d'une requète à la base de données.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("car")
public class CarEntity {

    /***
     * Identifiant de la voiture.
     */
    @Field("_id")
    private ObjectId id;

    /***
     * Modèle de la voiture.
     */
    @Field("model")
    private String model;

    /***
     * Manufacturié de la voiture.
     */
    @Field("manufacturer")
    private String manufacturer;

    /***
     * Couleur de la voiture.
     */
    @Field("color")
    private Integer color;
}

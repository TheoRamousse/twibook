package iut.uca.twibook.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import iut.uca.twibook.entities.enumerations.Color;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("car")
public class CarEntity {

    @Field("_id")
    private ObjectId id;

    @Field("model")
    private String model;

    @Field("manufacturer")
    private String manufacturer;

    @Field("color")
    private Integer color;
}

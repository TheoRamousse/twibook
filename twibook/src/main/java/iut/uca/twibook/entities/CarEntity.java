package iut.uca.twibook.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.awt.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Document("car")
public class CarEntity extends IdEntity {

    @Field("model")
    private String model;

    @Field("manufacturer")
    private String manufacturer;

    @Field("color")
    private Color color;
}

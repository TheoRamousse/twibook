package iut.uca.twibook.dtos;

import iut.uca.twibook.entities.enumerations.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private ObjectId id;

    private String model;

    private String manufacturer;

    private Color color;
}
package iut.uca.twibook.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
@Data
@Accessors
public abstract class IdEntity {

    @Id
    private ObjectId id;
}


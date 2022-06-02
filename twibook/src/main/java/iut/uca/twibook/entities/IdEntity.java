package iut.uca.twibook.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@Accessors
public abstract class IdEntity {

    @Id
    @Field("_id")
    private ObjectId id;
}


package iut.uca.twibook.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public abstract class IdEntity {

    @Id
    private ObjectId id;
}

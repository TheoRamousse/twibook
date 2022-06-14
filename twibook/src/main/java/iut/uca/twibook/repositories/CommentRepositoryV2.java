package iut.uca.twibook.repositories;

import iut.uca.twibook.entities.CommentEntity;
import iut.uca.twibook.entities.CommentEntityV2;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CommentRepositoryV2 extends MongoRepository<CommentEntityV2,String> {

    @Query ("{ schema_version : '2', _id: ?0}")
    CommentEntityV2 findById(ObjectId id);

    Long removeById(ObjectId _id);
}

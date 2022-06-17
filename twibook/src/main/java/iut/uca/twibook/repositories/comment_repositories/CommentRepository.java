package iut.uca.twibook.repositories.comment_repositories;

import iut.uca.twibook.entities.CommentEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<CommentEntity,String> {

    @Query("{ schema_version : '1', _id: ?0}")
    CommentEntity findById(ObjectId id);

    Long removeById(ObjectId _id);
}


package iut.uca.twibook.repositories;

import iut.uca.twibook.entities.CommentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<CommentEntity,String> {

}


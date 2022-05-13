package iut.uca.twibook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import iut.uca.twibook.entity.CommentEntity;

@Repository
public interface ICommentRepository extends MongoRepository<CommentEntity,String>{

}

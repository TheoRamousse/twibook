package uca.iut.twibook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uca.iut.twibook.entity.CommentEntity;

@Repository
public interface ICommentRepository extends MongoRepository<CommentEntity,String>{

}

package iut.uca.twibook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import iut.uca.twibook.entity.PostEntity;

@Repository
public interface IPostRepository extends MongoRepository<PostEntity, String>{

}

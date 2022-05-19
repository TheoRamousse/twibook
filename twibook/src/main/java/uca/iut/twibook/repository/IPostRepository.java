package uca.iut.twibook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uca.iut.twibook.entity.PostEntity;

@Repository
public interface IPostRepository extends MongoRepository<PostEntity, String>{

}

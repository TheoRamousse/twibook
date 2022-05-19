package uca.iut.twibook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uca.iut.twibook.entity.UserEntity;

@Repository
public interface IUserRepository extends MongoRepository<UserEntity, String>{

}

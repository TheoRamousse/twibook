package iut.uca.twibook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import iut.uca.twibook.entity.UserEntity;

@Repository
public interface IUserRepository extends MongoRepository<UserEntity, String>{

}

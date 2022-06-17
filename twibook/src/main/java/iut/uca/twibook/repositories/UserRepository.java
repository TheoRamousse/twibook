package iut.uca.twibook.repositories;

import iut.uca.twibook.entities.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    UserEntity findById(ObjectId id);

    UserEntity findByNickName(String email);

    boolean existsByEmail(String email);

    UserEntity findByEmail(String id);

    Long removeById(ObjectId _id);
}


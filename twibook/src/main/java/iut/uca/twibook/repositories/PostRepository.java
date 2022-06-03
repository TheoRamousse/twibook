package iut.uca.twibook.repositories;

import iut.uca.twibook.entities.PostEntity;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import iut.uca.twibook.entities.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
    Page<PostEntity> findAll(Pageable pageable);

    PostEntity findById(ObjectId id);

    Long removeById(ObjectId _id);
}


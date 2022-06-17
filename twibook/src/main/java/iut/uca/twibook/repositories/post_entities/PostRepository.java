package iut.uca.twibook.repositories.post_entities;

import iut.uca.twibook.entities.post_entities.PostEntity;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
    Page<PostEntity> findAll(Pageable pageable);

    @Query("{ schema_version : '1', _id: ?0}")
    PostEntity findById(ObjectId id);
    Long removeById(ObjectId _id);
}


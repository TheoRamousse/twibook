package iut.uca.twibook.repositories.post_entities;

import iut.uca.twibook.entities.post_entities.PostEntityV2;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PostRepositoryV2 extends MongoRepository<PostEntityV2, String> {
    Page<PostEntityV2> findAll(Pageable pageable);

    @Query("{ schema_version : '2', _id: ?0}")
    PostEntityV2 findById(ObjectId id);

    Long removeById(ObjectId _id);
}

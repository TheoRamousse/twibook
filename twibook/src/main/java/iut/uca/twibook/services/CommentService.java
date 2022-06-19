package iut.uca.twibook.services;

import iut.uca.twibook.Status;
import iut.uca.twibook.entities.comment_entities.CommentEntity;
import iut.uca.twibook.entities.comment_entities.CommentEntityV2;
import iut.uca.twibook.mappers.CommentMapper;
import iut.uca.twibook.repositories.comment_repositories.CommentRepository;
import iut.uca.twibook.repositories.comment_repositories.CommentRepositoryV2;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository repository;

    @Autowired
    CommentRepositoryV2 repositoryV2;

    @Autowired
    CommentMapper commentMapper;

    public CommentEntityV2 findById(ObjectId id){
        CommentEntity commentEntity = repository.findById(id);
        CommentEntityV2 commentEntityV2;

        if(commentEntity != null) {
            commentEntityV2 = commentMapper.toCurrentVersion(commentEntity);
        }
        else {
            commentEntityV2 = repositoryV2.findById(id);
        }

        if(commentEntityV2 == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
        }

        return commentEntityV2;
    }

    public List<CommentEntityV2> getComments(){
        List<CommentEntity> commentEntityList = repository.findAll();
        List<CommentEntityV2> commentEntityV2List = repositoryV2.findAll();
        List<CommentEntityV2> temporaryList;

        if(!commentEntityList.isEmpty()) {
            temporaryList = commentMapper.toCurrentVersion(commentEntityList);
            temporaryList.removeAll(commentEntityV2List);
            commentEntityV2List.addAll(temporaryList);
        }

        return commentEntityV2List;
    }

    public class EntityAndCodeResult{
        private Status status;
        private CommentEntityV2 entity;

        public EntityAndCodeResult(Status status, CommentEntityV2 entity){
            this.entity = entity;
            this.status = status;
        }

        public Status getStatus() {
            return status;
        }

        public CommentEntityV2 getEntity() {
            return entity;
        }
    }

    public EntityAndCodeResult createComment(CommentEntityV2 commentEntityV2){
        Status response;

        if(commentEntityV2.getId() != null && repositoryV2.existsById(commentEntityV2.getId().toString())) {
            response = Status.UPDATED;
        }
        else {
            response = Status.CREATED;
            commentEntityV2.setSchemaVersion("2");
        }
        return new EntityAndCodeResult(response ,repositoryV2.save(commentEntityV2));
    }

    public Long deleteComment(ObjectId commentToDelete) {
        return repository.removeById(commentToDelete);
    }

}

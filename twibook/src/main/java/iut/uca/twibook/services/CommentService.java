package iut.uca.twibook.services;

import iut.uca.twibook.Status;
import iut.uca.twibook.entities.CommentEntity;
import iut.uca.twibook.entities.PostEntity;
import iut.uca.twibook.repositories.CommentRepository;
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

    public CommentEntity findById(ObjectId id){
        CommentEntity commentEntity = repository.findById(id);
        if(commentEntity == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
        }
        return commentEntity;
    }

    public List<CommentEntity> getComments(){
        return repository.findAll();
    }

    public Status createComment(CommentEntity commentEntity){
        Status response;

        if(commentEntity.getId() == null) {

            response = Status.CREATED;
        }
        else {
            response = Status.UPDATED;
        }
        repository.save(commentEntity);
        return response;
    }

    public Long deleteComment(ObjectId commentToDelete) {
        return repository.removeById(commentToDelete);
    }

}

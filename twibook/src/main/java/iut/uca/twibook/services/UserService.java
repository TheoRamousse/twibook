package iut.uca.twibook.services;

import iut.uca.twibook.Status;
import iut.uca.twibook.entities.UserEntity;
import iut.uca.twibook.mappers.UserMapper;
import iut.uca.twibook.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

    public UserEntity findById(ObjectId id){
        UserEntity userEntity = repository.findById(id);
        if(userEntity == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return userEntity;
    }

    public List<UserEntity> getUsers(){
        return repository.findAll();
    }

    public Status createUser(UserEntity userEntity){
        Status response;

        UserEntity userToUpdate = repository.findByEmail(userEntity.getEmail());

        if(userToUpdate == null) {
            userEntity.setId(new ObjectId());

            response = Status.CREATED;
        }
        else {
            userEntity.setId(userToUpdate.getId());
            response = Status.UPDATED;
        }
        repository.save(userEntity);
        return response;
    }

    public Long deleteUser(ObjectId userToDelete) {
        return repository.removeById(userToDelete);
    }
}

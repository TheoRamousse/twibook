package iut.uca.twibook.services;

import iut.uca.twibook.Status;
import iut.uca.twibook.entities.UserEntity;
import iut.uca.twibook.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

    /***
     * Cette méthode permet de récupérer un utilisateur à partir de son Id.
     * @param id L'Id de l'utilisateur à récupérer.
     * @return Retourne l'utilisateur dans son intégralité ou renvoie une erreur 404 si l'utilisateur n'est pas trouvé.
     */
    public UserEntity findById(ObjectId id){
        UserEntity userEntity = repository.findById(id);
        if(userEntity == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return userEntity;
    }

    /***
     * Cette méthode permet de récupérer un utilisateur à partir de son pseudo.
     * @param nickName Le pseudo de l'utilisateur à récupérer.
     * @return Retourne l'utilisateur dans son intégralité ou renvoie une erreur 404 si l'utilisateur n'est pas trouvé.
     */
    public UserEntity findByNickName(String nickName){
        UserEntity userEntity = repository.findByNickName(nickName);
        if(userEntity == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return userEntity;
    }

    /***
     * Cette méthode permet de récupérer l'ensemble des utilisateurs présents en base.
     * @return Retourne l'ensemble des utilisateurs.
     */
    public List<UserEntity> getUsers(){
        return repository.findAll();
    }

    /***
     * Cette méthode permet d'ajouter ou de modifier un utilisateur si l'Id a été renseigné.
     * @param userEntity L'utilisateur à ajouter ou modifier.
     * @return Retourne si l'utilisateur a été créé ou modifié.
     */
    public Status createUser(UserEntity userEntity){
        Status response;

        UserEntity userToUpdate = repository.findByEmail(userEntity.getEmail());

        if(userToUpdate == null) {
            response = Status.CREATED;
        }
        else {
            userEntity.setId(userToUpdate.getId());
            response = Status.UPDATED;
        }
        repository.save(userEntity);
        return response;
    }

    /***
     * Cette méthode permet de supprimer un utilisateur à partir de son Id.
     * @param userToDelete L'Id de l'utilisateur à supprimer.
     * @return Retourne un long indiquant si l'utilisateur a bien été supprimé ou non.
     */
    public Long deleteUser(ObjectId userToDelete) {
        return repository.removeById(userToDelete);
    }
}

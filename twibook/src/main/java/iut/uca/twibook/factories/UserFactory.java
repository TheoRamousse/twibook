package iut.uca.twibook.factories;
import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.entities.UserEntity;
import org.bson.types.ObjectId;

public class UserFactory{
    public static UserDTO createDTO(UserEntity user){
        UserDTO dto = new UserDTO();
       
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setNickName(user.getNickName());
        dto.setImgUrl(user.getImageUrl());
        dto.setBirthDate(user.getBirthDate());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getEmail());
        //dto.setPosts(user.getPosts());
        //dto.setCars(user.getCars());
        dto.setId(user.getId().toString());
        return dto;
    }

    public static UserEntity createEntity(UserDTO user){
        UserEntity entity = new UserEntity();

        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setNickName(user.getNickName());
        entity.setImageUrl(user.getImgUrl());
        entity.setBirthDate(user.getBirthDate());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        //entity.setCars(user.getCars());
        //entity.setPosts(user.getPosts());
        entity.setId(new ObjectId(user.getId()));
        return entity;
    }
}
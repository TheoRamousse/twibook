package iut.uca.twibook.factories;
import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.entities.UserEntity;
import org.bson.types.ObjectId;

public class UserFactory{
    public static UserDTO CreateDTO(UserEntity user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId().toString());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setNickName(user.getNickName());
        dto.setImgUrl(user.getImgUrl());
        dto.setBirthDate(user.getBirthDate());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getEmail());
        return dto;
    }

    public static UserEntity CreateEntity(UserDTO user){
        UserEntity entity = new UserEntity();
        entity.setId(new ObjectId(user.getId()));
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setNickName(user.getNickName());
        entity.setImgUrl(user.getImgUrl());
        entity.setBirthDate(user.getBirthDate());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        return entity;
    }
}
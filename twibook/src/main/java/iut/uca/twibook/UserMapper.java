package iut.uca.twibook;

import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    List<UserDTO> listToDTO(List<UserEntity> myEntity);
    UserDTO toDTO(UserEntity myEntity);
}

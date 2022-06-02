package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.PostDTO;
import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.entities.PostEntity;
import iut.uca.twibook.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class, PostMapper.class, CarMapper.class})
@ApplicationScope
public interface UserMapper {

    UserDTO toDTO(UserEntity userEntity);
    UserEntity toEntity(UserDTO userDTO);

    List<UserEntity> toListEntity(List<UserDTO> userDTOList);
    List<UserDTO> toListDTO(List<UserEntity> userEntityList);
}

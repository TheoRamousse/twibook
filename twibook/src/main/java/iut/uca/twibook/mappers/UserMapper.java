package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.entities.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class, CarMapper.class})
@ApplicationScope
public interface UserMapper {

    UserDTO toDTO(UserEntity userEntity);
    UserEntity toEntity(UserDTO userDTO);

    List<UserEntity> toListEntity(List<UserDTO> userDTOList);
    List<UserDTO> toListDTO(List<UserEntity> userEntityList);
}

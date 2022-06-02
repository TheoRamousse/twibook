package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.context.annotation.ApplicationScope;

@Mapper(componentModel = "spring", uses = ObjectIdMapper.class)
@ApplicationScope
public interface UserMapper {

    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(UserEntity userEntity);
    UserEntity toEntity(UserDTO userDTO);
}

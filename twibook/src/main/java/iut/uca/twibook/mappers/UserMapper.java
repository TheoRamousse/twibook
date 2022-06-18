package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.entities.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

/***
 * Mapper de d'utilisateur.
 */
@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class, CarMapper.class})
@ApplicationScope
public interface UserMapper {

    /***
     * Cette méthode permet de convertir une UserEntity en un UserDTO.
     * @param userEntity La UserEntity à convertir.
     * @return Retourne la UserEntity convertie en UserDTO.
     */
    UserDTO toDTO(UserEntity userEntity);

    /***
     * Cette méthode permet de convertir un UserDTO en une UserEntity.
     * @param userDTO Le UserDTO à convertir.
     * @return Retourne le UserDTO converti en UserEntity.
     */
    UserEntity toEntity(UserDTO userDTO);

    /***
     * Cette méthode permet de convertir une liste de UserEntity en une liste de UserDTO.
     * @param userEntityList La liste de UserEntity à convertir.
     * @return etourne la liste de UserEntity convertie en une liste de UserDTO.
     */
    List<UserDTO> toListDTO(List<UserEntity> userEntityList);
}

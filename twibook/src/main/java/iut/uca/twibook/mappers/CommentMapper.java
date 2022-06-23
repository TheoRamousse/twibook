package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.CommentDTO;
import iut.uca.twibook.entities.comment_entities.CommentEntity;
import iut.uca.twibook.entities.comment_entities.CommentEntityV2;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

/***
 * Mapper de commentaire.
 */
@ApplicationScope
@Mapper(componentModel = "spring" , uses = { ObjectIdMapper.class})
public interface CommentMapper {

    /***
     * Cette méthode permet de transformer un CommentDTO en  CommentEntiy.
     * @param commentDTO Le CommentDTO à transformer.
     * @return Retourne une CommentEntity.
     */
    CommentEntity toEntity(CommentDTO commentDTO);

    /***
     * Cette méthode permet de transformer une CommentEntity en CommentDTO.
     * @param commentEntity La CommentEntity à transformer.
     * @return Retourne un CommentDTO.
     */
    CommentDTO toDTO(CommentEntity commentEntity);

    /***
     * Cette méthode permet de convertir une CommentEntity de version ultérieur en CommentEntity de version actuel.
     * @param commentEntity La commentEntity à convertir.
     * @return Retourne une CommentEntity dans la version actuel.
     */
    CommentEntityV2 toCurrentVersion(CommentEntity commentEntity);

    /***
     * Cette méthode permet de convertir une liste de CommentEntity de version ultérieur en liste CommentEntity de version actuel.
     * @param commentEntityList La commentEntity à convertir.
     * @return Retourne une CommentEntity dans la version actuel.
     */
    List<CommentEntityV2> toCurrentVersion(List<CommentEntity> commentEntityList);

    /***
     * Cette méthode permet de convertir un CommentDTO en une CommentEntity de version actuel.
     * @param commentDTO Le commentDTO à convertir.
     * @return Retourne une CommentEntity dans la version actuel.
     */
    CommentEntityV2 toEntityV2(CommentDTO commentDTO);

    /***
     * Cette méthode permet de convertir une CommentEntity de version actuel en un CommentDTO.
     * @param commentEntityV2 La CommentEntity à convertir.
     * @return Retourne un CommentDTO.
     */
    CommentDTO toDTO(CommentEntityV2 commentEntityV2);

    /***
     * Cette méthode permet de convertir une liste de CommentEntity de version ultière en une liste de CommentDTO.
     * @param commentEntityList La liste de CommentEntity de version ultérieur à convertir.
     * @return Retourne une liste de CommentDTO.
     */
    List<CommentDTO> toListDTO(List<CommentEntity> commentEntityList);

    /***
     * Cette méthode permet de convertir une liste de CommentEntity de version actuel en une liste de CommentDTO.
     * @param commentEntityV2List La liste de CommentEntity de version actuel à convertir.
     * @return Retourne une liste de CommentDTO.
     */
    List<CommentDTO> toListDTOwithV2(List<CommentEntityV2> commentEntityV2List);
}


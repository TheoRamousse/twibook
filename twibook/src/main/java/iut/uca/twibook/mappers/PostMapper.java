package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.PostDTO;
import iut.uca.twibook.entities.post_entities.PostEntity;
import iut.uca.twibook.entities.post_entities.PostEntityV2;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

/**
 * Mapper de post
 */
@ApplicationScope
@Mapper(componentModel = "spring", uses = { ObjectIdMapper.class})
public interface PostMapper {

    /***
     * Cette méthode permet de convertir un PostDTO en une PostEntity de version ultérieur.
     * @param postDTO Le PostDTO à convertir.
     * @return Retourne le PostDTO converti en PostEntity de version ultérieur.
     */
    PostEntity toEntity(PostDTO postDTO);

    /***
     * Cette méthode permet de convertir une PostEntity de version ultérieur en un PostDTO.
     * @param postEntity La PostEntity de version utlérieur à convertir.
     * @return Retourne la PostEntity de version ultérieur convertie en PostDTO.
     */
    PostDTO toDTO(PostEntity postEntity);

    /***
     * Cette méthode permet de convertir une PostEntity de version actuel en un PostDTO.
     * @param postEntityV2 La PostEntity de version actuel à convertir.
     * @return Retourne la PostEntity de version actuel convertie en PostDTO.
     */
    PostDTO toDTO(PostEntityV2 postEntityV2);

    /***
     * Cette méthode permet de convertir un PostDTO en une PostEntity de version actuel.
     * @param postDTO Le PostDTO à convertir.
     * @return Retourne le PostDTO converti en PostEntity de version actuel.
     */
    PostEntityV2 toEntityV2(PostDTO postDTO);

    /***
     * Cette méthode permet de convertir une liste de PostEntity de version actuel en une liste de PostDTO
     * @param postEntityV2List La liste de PostEntity de version actuel à convertir.
     * @return Retourne la liste de PostEntity de version actuel en une liste de PostDTO.
     */
    List<PostDTO> toListDTOwithV2(List<PostEntityV2> postEntityV2List);

    /***
     * Cette méthode permet de convertir une liste de PostEntity de version ultérieur en une liste de PostDTO
     * @param postEntityList La liste de PostEntity de version ultérieur à convertir.
     * @return Retourne la liste de PostEntity de version ultérieur en une liste de PostDTO.
     */
    List<PostDTO> toListDTO(List<PostEntity> postEntityList);

    /***
     * Cette méthode permet de convertir une PostEntity de version ultérieur en une PostEntity de version actuel
     * @param postEntity La PostEntity de version ultérieur à convertir.
     * @return Retourne la PostEntity de version ultérieur convertie en PostEntity de version actuel.
     */
    PostEntityV2 toCurrentVersion(PostEntity postEntity);

    /***
     * Cette méthode permet de convertir une liste de PostEntity de version ultérieur en une liste de PostEntity de version actuel
     * @param postEntityList La liste de PostEntity de version ultérieur à convertir.
     * @return Retourne la liste de PostEntity de version ultérieur convertie en liste de PostEntity de version actuel.
     */
    List<PostEntityV2> toCurrentVersion(List<PostEntity> postEntityList);
}

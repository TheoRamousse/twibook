package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.CarDTO;
import iut.uca.twibook.entities.CarEntity;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

/***
 * Mapper de voiture.
 */
@ApplicationScope
@Mapper(componentModel = "spring", uses = { ObjectIdMapper.class, ColorMapper.class})
public interface CarMapper {

    /***
     * Cette fonction permet de transformer une CarEntity en CarDTO.
     * @param carDTO CarDTO est la voiture à transformer.
     * @return Retourne la voiture transformé.
     */
    CarEntity toEntity(CarDTO carDTO);

    /***
     * Cette fonction permet de transformer un CarDTO en CarEntity.
     * @param carEntity CarEntity est la voiture à transformer.
     * @return Retourne la voiture transformé.
     */
    CarDTO toDTO(CarEntity carEntity);

    /***
     * Cette fonction permet de transformer un CarDTO en CarEntity.
     * @param carDTOList Liste de CarDTO à transformer.
     * @return Retourne une liste de CarEntity.
     */
    List<CarEntity> toListEntity(List<CarDTO> carDTOList);

    /***
     * Cette fonction permet de transformer un CarDTO en CarEntity.
     * @param carEntityList Liste de CarEntity à transformer.
     * @return Retourne une liste de CarDTO.
     */
    List<CarDTO> toListDTO(List<CarEntity> carEntityList);
}

package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.CarDTO;
import iut.uca.twibook.entities.CarEntity;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@ApplicationScope
@Mapper(componentModel = "spring", uses = { ObjectIdMapper.class, ColorMapper.class})
public interface CarMapper {

    CarEntity toEntity(CarDTO carDTO);
    CarDTO toDTO(CarEntity carEntity);

    List<CarEntity> toListEntity(List<CarDTO> carDTOList);
    List<CarDTO> toListDTO(List<CarEntity> carEntityList);
}

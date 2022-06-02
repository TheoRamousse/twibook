package iut.uca.twibook.mappers;

import iut.uca.twibook.entities.enumerations.Color;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Arrays;

@ApplicationScope
@Mapper(componentModel = "spring")
public interface ColorMapper {

    default Integer toInteger(Color value){
        return value != null ? value.ordinal() : null;
    }

    default Color toColor(Integer value){
        return value != null ? (Color) Arrays.stream(Color.values()).toArray()[value] : null;
    }
}

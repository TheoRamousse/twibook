package iut.uca.twibook.mappers;

import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/***
 * Mapper de Date.
 */
@ApplicationScope
@Mapper(componentModel = "spring")
public interface DateMapper {

    /***
     * Cette méthode permet de convertir une date au format LocalDate en une date de type LocalDateTime.
     * @param localDate La date à convertir.
     * @return Retourne la date convertie au format LocalDateTime.
     */
    default LocalDateTime toLocalDateTime(LocalDate localDate) {
        return localDate.atTime(0,0,0);
    }
}

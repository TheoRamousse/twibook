package iut.uca.twibook.mappers;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.*;

/***
 * Mapper de Date.
 */
@ApplicationScope
@Mapper(componentModel = "spring")
public interface DateMapper {

    /***
     * Cette méthode permet de convertir une date au format long (Timestamp) en une date de type LocalDate.
     * @param timestamp La date à convertir.
     * @return Retourne la date convertie au format LocalDate.
     */
    default LocalDate toLocalDate(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}

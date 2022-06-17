package iut.uca.twibook.mappers;

import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ApplicationScope
@Mapper(componentModel = "spring")
public interface DateMapper {

    default LocalDateTime toLocalDateTime(LocalDate localDate) {
        return localDate.atTime(0,0,0);
    }
}

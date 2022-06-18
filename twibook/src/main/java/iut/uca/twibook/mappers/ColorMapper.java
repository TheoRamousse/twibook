package iut.uca.twibook.mappers;

import iut.uca.twibook.entities.enumerations.Color;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Arrays;

/***
 * Mapper de couleur.
 */
@ApplicationScope
@Mapper(componentModel = "spring")
public interface ColorMapper {

    /***
     * Cette méthode permet de transformé une couleur en entier stockable en base.
     * @param value La couleur à stocker.
     * @return Retourne un entier corespondant à la couleur.
     */
    default Integer toInteger(Color value){
        return value != null ? value.ordinal() : null;
    }

    /***
     * ette méthode permet de transformé un entier stocké en base en couleur.
     * @param value L'entier corespondant à la couleur.
     * @return Retourne la couleur sous la forme d'une Color.
     */
    default Color toColor(Integer value){
        return value != null ? (Color) Arrays.stream(Color.values()).toArray()[value] : null;
    }
}

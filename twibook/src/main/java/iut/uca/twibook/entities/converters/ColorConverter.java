package iut.uca.twibook.entities.converters;

import iut.uca.twibook.entities.enumerations.Color;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

import java.util.Arrays;

public class ColorConverter {
    /*
    @ReadingConverter
    public class PersonReadConverter implements Converter<Integer, Color> {

        public Color convert(Integer source) {
            return (Color) Arrays.stream(Color.values()).toArray()[source];
        }

    }

    @WritingConverter
    public class ColorWriteConverter implements Converter<Color, Integer> {

        @Override
        public Integer convert(Color source) {
            return source.ordinal();
        }
    }

     */
}

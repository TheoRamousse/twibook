package iut.uca.twibook.entities.converters;

import iut.uca.twibook.entities.enumerations.Color;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.Arrays;

@ReadingConverter
public class ColorReadConverter implements Converter<Integer, Color> {

	@Override
	public Color convert(Integer source) {
		return (Color) Arrays.stream(Color.values()).toArray()[source];
	}

}


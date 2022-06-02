package iut.uca.twibook.entities.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import iut.uca.twibook.entities.enumerations.Color;

@WritingConverter
public class ColorWriteConverter implements Converter<Color, Integer> {

	@Override
	public Integer convert(Color source) {
		return source.ordinal();
	}
}
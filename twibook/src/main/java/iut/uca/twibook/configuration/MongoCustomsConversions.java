package iut.uca.twibook.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import iut.uca.twibook.entities.converters.ColorReadConverter;
import iut.uca.twibook.entities.converters.ColorWriteConverter;


@Configuration
public class MongoCustomsConversions {

  @Bean
  public MongoCustomConversions mongoCustomConversions() {

    return new MongoCustomConversions(
        Arrays.asList(
            new ColorReadConverter(),
            new ColorWriteConverter()));
  }
}

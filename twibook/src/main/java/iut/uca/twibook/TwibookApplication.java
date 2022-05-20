package iut.uca.twibook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TwibookApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwibookApplication.class, args);
	}

}

package iut.uca.twibook.entity;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "TwibookUser")
public class UserEntity extends IdEntity{
	
	private String first_name;
	private String last_name;
	private String nick_name;
	private String img_url;
	private LocalDate birth_date;
	private String email;
	private String password;
	

}

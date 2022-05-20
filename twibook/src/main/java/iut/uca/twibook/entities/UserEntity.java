package iut.uca.twibook.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

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


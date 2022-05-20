package iut.uca.twibook.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "TwibookUser")
public class UserEntity extends IdEntity{

    private String firstName;
    private String lastName;
    private String nickName;
    private String imgUrl;
    private LocalDate birthDate;
    private String email;
    private String password;


}


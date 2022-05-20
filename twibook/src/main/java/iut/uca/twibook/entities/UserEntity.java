package iut.uca.twibook.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "TwibookUser")
@Accessors(chain = true)
public class UserEntity extends IdEntity{
    private String firstName;
    private String lastName;
    private String nickName;
    private String imgUrl;
    private LocalDate birthDate;
    private String email;
    private String password;


}


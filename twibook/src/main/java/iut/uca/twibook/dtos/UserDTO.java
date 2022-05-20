package iut.uca.twibook.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String imgUrl;
    private LocalDate birthDate;
    private String email;
    private String password;
}

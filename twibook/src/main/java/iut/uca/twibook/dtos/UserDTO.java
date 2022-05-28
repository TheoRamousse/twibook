package iut.uca.twibook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String idDTO;
    private String firstName;
    private String lastName;
    private String nickName;
    private String imgUrl;
    private LocalDate birthDate;
    private String email;
    private String password;
}

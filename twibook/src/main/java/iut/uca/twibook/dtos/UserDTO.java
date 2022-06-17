package iut.uca.twibook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String imageUrl;
    private LocalDate birthDate;
    private String email;
    private String password;
    private List<String> posts;
    private List<CarDTO> cars;

}



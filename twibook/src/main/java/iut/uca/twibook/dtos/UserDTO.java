package iut.uca.twibook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import iut.uca.twibook.entities.CarEntity;
import iut.uca.twibook.entities.PostEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String imgUrl;
    private LocalDate birthDate;
    private String email;
    private String password;
    private Collection<PostEntity> posts;
    private Collection<CarEntity> cars;

}



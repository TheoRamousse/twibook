package iut.uca.twibook.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "twibookUser")
public class UserEntity extends IdEntity {

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("nick_name")
    private String nickName;

    @Field("image_url")
    private String imageUrl;

    @Field("birth_date")
    private LocalDate birthDate;

    @Field("email")
    @Indexed
    private String email;

    @Field("password")
    private String password;

    @DBRef(lazy = true)
    @Field("posts")
    private Collection<PostEntity> posts;

    @Field("cars")
    private Collection<CarEntity> cars;
}

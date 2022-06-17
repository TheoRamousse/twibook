package iut.uca.twibook.entities;

import iut.uca.twibook.dtos.CarDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "twibookUser")
public class UserEntity {

    @Id
    @Field("_id")
    private ObjectId id;

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

    @Field("posts")
    private List<String> posts;

    @Field("cars")
    private List<CarEntity> cars;

    public static final String SCHEMA_VERSION = "1";
}

package iut.uca.twibook.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("comment")
public class CommentEntityV2 {

    public static final String SCHEMA_VERSION = "2";

    @Field("_id")
    private ObjectId id;

    @Field("text")
    private String text;

    @Field("publication_date")
    private LocalDateTime publicationDate;

    @Field("user_nick_name")
    private String userNickName;

    @Field("user_image_url")
    private String userImageUrl;

    @Field("schema_version")
    private String schemaVersion;

}

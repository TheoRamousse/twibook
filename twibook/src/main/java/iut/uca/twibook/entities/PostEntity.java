package iut.uca.twibook.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Document("Post")
public class PostEntity extends IdEntity{

    private String text;
    private LocalDateTime publication_date;
    private String first_comment_text;
    private String first_comment_user_image_url;
    private String first_commetn_user_nick_name;

}


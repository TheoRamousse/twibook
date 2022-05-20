package iut.uca.twibook.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Document("Comment")
public class CommentEntity extends IdEntity{

    private String text;
    private LocalDateTime publication_date;
    private String user_nick_name;
    private String user_image_url;

}


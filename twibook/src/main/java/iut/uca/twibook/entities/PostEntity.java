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
    private LocalDateTime publicationDate;
    private String firstCommentText;
    private String firstCommentUserImageUrl;
    private String firstCommetnUserNickName;

}


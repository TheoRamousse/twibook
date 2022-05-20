package iut.uca.twibook.dtos;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors
public class CommentDTO {
	private String id;
	private String text;
    private LocalDateTime publicationDate;
    private String user_nickName;
    private String userImageUrl;
}

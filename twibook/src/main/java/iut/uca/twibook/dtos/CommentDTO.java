package iut.uca.twibook.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Data
@Accessors
public class CommentDTO {
	private String id;
	private String text;
    private LocalDate publicationDate;
    private String user_nickName;
    private String userImageUrl;
}

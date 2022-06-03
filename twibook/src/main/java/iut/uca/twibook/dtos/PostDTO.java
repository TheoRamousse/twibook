package iut.uca.twibook.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;


import iut.uca.twibook.entities.CommentEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class PostDTO {

	private String id;
	private String text;
	private LocalDate publicationDate;
	private String firstCommentText;
	private String firstCommentUserImageUrl;
	private String firstCommentUserNickName;
	private Collection<CommentDTO> comments;
	
}

package iut.uca.twibook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

	private String id;
	private String text;
	private String postImage;
	private LocalDate publicationDate;
	private String firstCommentText;
	private String firstCommentUserImageUrl;
	private String firstCommentUserNickName;
	private List<String> comments;
	
}

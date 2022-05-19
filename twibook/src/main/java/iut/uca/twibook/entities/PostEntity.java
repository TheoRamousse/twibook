package iut.uca.twibook.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(callSuper = false)
@Document("post")
public class PostEntity extends IdEntity{

	@Field("text")
	private String text;

	@Field("publication_date")
	private LocalDateTime publicationDate;

	@Field("first_comment_text")
	private String firstCommentText;

	@Field("first_comment_user_image_url")
	private String firstCommentUserImageUrl;

	@Field("first_comment_user_nick_name")
	private String firstCommentUserNickName;

	@DBRef(lazy = true)
	@Field("comments")
	private Collection<CommentEntity> comments;

}

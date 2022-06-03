package iut.uca.twibook.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("post")
public class PostEntity{

	@Field("_id")
	private ObjectId id;

	@Field("text")
	private String text;

	@Field("publication_date")
	private LocalDate publicationDate;

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

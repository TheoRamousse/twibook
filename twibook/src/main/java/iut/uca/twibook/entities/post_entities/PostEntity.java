package iut.uca.twibook.entities.post_entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("post")
public class PostEntity{

	public static final String SCHEMA_VERSION = "1";

	@Id
	@Field("_id")
	private ObjectId id;

	@Field("text")
	private String text;

	@Field("post_image")
	private String postImage;

	@Field("publication_date")
	private LocalDate publicationDate;

	@Field("first_comment_text")
	private String firstCommentText;

	@Field("first_comment_user_image_url")
	private String firstCommentUserImageUrl;

	@Field("first_comment_user_nick_name")
	private String firstCommentUserNickName;

	@Field("comments")
	private List<String> comments;

	@Field("schema_version")
	private String schemaVersion;
}

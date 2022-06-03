package iut.uca.twibook.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("comment")
public class CommentEntity {

	@Field("_id")
	private ObjectId id;

	@Field("text")
	private String text;

	@Field("publication_date")
	private LocalDate publicationDate;

	@Field("user_nick_name")
	private String userNickName;

	@Field("user_image_url")
	private String userImageUrl;

}

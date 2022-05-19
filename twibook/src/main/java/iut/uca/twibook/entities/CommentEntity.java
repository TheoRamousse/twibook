package iut.uca.twibook.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(callSuper = false)
@Document("comment")
public class CommentEntity extends IdEntity{
	@Field("text")
	private String text;

	@Field("publication_date")
	private LocalDateTime publicationDate;

	@Field("user_nick_name")
	private String userNickName;

	@Field("user_image_url")
	private String userImageUrl;

}

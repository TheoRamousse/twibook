package iut.uca.twibook.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document("Comment")
public class CommentEntity extends IdEntity{

	private String text;
	private String publication_date;
	private String user_nick_name;
	private String user_image_url;

}

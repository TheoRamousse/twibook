package uca.iut.twibook.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document("Comment")
public class CommentEntity extends IdEntity{

	private String text;
	private LocalDateTime publication_date;
	private String user_nick_name;
	private String user_image_url;

}

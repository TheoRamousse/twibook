package iut.uca.twibook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Data
@Accessors
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
	private String id;
	private String text;
    private LocalDate publicationDate;
    private String userNickName;
    private String userImageUrl;
}

package iut.uca.twibook.factories;


import org.bson.types.ObjectId;


import iut.uca.twibook.dtos.PostDTO;
import iut.uca.twibook.entities.PostEntity;

public class PostFactory {

	public static PostDTO createDTO(PostEntity entity){
        PostDTO dto = new PostDTO();

        dto.setComments(entity.getComments());
        dto.setFirstCommentText(entity.getFirstCommentText());
        dto.setFirstCommentUserImageUrl(entity.getFirstCommentUserImageUrl());
        dto.setFirstCommentUserNickName(entity.getFirstCommentUserNickName());
        dto.setId(entity.getId().toString());
        dto.setPublicationDate(entity.getPublicationDate());
        dto.setText(entity.getText());
        return dto;
    }

	 public static PostEntity createEntity(PostDTO post){
	        PostEntity entity = new PostEntity();

	        entity.setComments(post.getComments());
	        entity.setFirstCommentText(post.getFirstCommentText());
	        entity.setFirstCommentUserImageUrl(post.getFirstCommentUserImageUrl());
	        entity.setFirstCommentUserNickName(post.getFirstCommentUserNickName());
	        entity.setPublicationDate(post.getPublicationDate());
	        entity.setText(post.getText());
	        return entity;
	    }
}

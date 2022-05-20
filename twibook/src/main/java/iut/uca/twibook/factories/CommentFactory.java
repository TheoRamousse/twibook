package iut.uca.twibook.factories;

import org.bson.types.ObjectId;

import iut.uca.twibook.dtos.CommentDTO;
import iut.uca.twibook.entities.CommentEntity;

public class CommentFactory {

	public static CommentDTO createDTO(CommentEntity comment){
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId().toString());
        dto.setPublicationDate(comment.getPublicationDate());
        dto.setText(comment.getText());
        dto.setUser_nickName(comment.getUserNickName());
        dto.setUserImageUrl(comment.getUserImageUrl());
        return dto;
    }
	
	public static CommentEntity createEntity(CommentDTO comment){
		CommentEntity entity = new CommentEntity();
		entity.setId(new ObjectId(comment.getId()));
		entity.setPublicationDate(comment.getPublicationDate());
		entity.setText(comment.getText());
		entity.setUserNickName(comment.getUser_nickName());
		entity.setUserImageUrl(comment.getUserImageUrl());
		return entity;
		
	}
}

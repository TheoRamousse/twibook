package iut.uca.twibook.factories;

import org.bson.types.ObjectId;

import iut.uca.twibook.dtos.CommentDTO;
import iut.uca.twibook.entities.CommentEntity;

public class CommentFactory {

	public static CommentDTO CreateDTO(CommentEntity comment){
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId().toString());
        dto.setPublicationDate(comment.getPublicationDate());
        dto.setText(comment.getText());
        dto.setUser_nickName(comment.getUser_nickName());
        dto.setUserImageUrl(comment.getUserImageUrl());
        return dto;
    }
	
	public static CommentEntity CreateEntity(CommentDTO comment){
		CommentEntity entity = new CommentEntity();
		entity.setId(new ObjectId(comment.getId()));
		entity.setPublicationDate(comment.getPublicationDate());
		entity.setText(comment.getText());
		entity.setUser_nickName(comment.getUser_nickName());
		entity.setUserImageUrl(comment.getUserImageUrl());
		return entity;
		
	}
}

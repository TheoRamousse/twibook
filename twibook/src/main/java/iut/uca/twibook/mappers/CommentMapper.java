package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.CommentDTO;
import iut.uca.twibook.dtos.PostDTO;
import iut.uca.twibook.entities.CommentEntity;
import iut.uca.twibook.entities.PostEntity;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@ApplicationScope
@Mapper(componentModel = "spring" , uses = ObjectIdMapper.class)
public interface CommentMapper {

    CommentEntity toEntity(CommentDTO commentDTO);
    CommentDTO toDTO(CommentEntity commentEntity);

    List<CommentEntity> toListEntity(List<CommentDTO> commentDTOList);
    List<CommentDTO> toListDTO(List<CommentEntity> commentEntityList);
}

package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.CommentDTO;
import iut.uca.twibook.entities.comment_entities.CommentEntity;
import iut.uca.twibook.entities.comment_entities.CommentEntityV2;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@ApplicationScope
@Mapper(componentModel = "spring" , uses = { ObjectIdMapper.class})
public interface CommentMapper {

    CommentEntity toEntity(CommentDTO commentDTO);
    CommentDTO toDTO(CommentEntity commentEntity);

    CommentEntityV2 toCurrentVersion(CommentEntity commentEntity);

    List<CommentEntityV2> toCurrentVersion(List<CommentEntity> commentEntityList);

    CommentEntityV2 toEntityV2(CommentDTO commentDTO);
    CommentDTO toDTO(CommentEntityV2 commentEntityV2);

    List<CommentDTO> toListDTO(List<CommentEntity> commentEntityList);

    List<CommentDTO> toListDTOwithV2(List<CommentEntityV2> commentEntityV2List);
}

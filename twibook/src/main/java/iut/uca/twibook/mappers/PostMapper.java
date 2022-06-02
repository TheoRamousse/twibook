package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.PostDTO;
import iut.uca.twibook.entities.CommentEntity;
import iut.uca.twibook.entities.PostEntity;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@ApplicationScope
@Mapper(componentModel = "spring", uses = { ObjectIdMapper.class, CommentMapper.class})
public interface PostMapper {

    PostEntity toEntity(PostDTO postDTO);
    PostDTO toDTO(PostEntity postEntity);

    List<PostEntity> toListEntity(List<PostDTO> postDTOList);
    List<PostDTO> toListDTO(List<PostEntity> postEntityList);
}

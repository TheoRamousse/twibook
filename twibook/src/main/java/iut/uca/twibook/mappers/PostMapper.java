package iut.uca.twibook.mappers;

import iut.uca.twibook.dtos.PostDTO;
import iut.uca.twibook.entities.post_entities.PostEntity;
import iut.uca.twibook.entities.post_entities.PostEntityV2;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@ApplicationScope
@Mapper(componentModel = "spring", uses = { ObjectIdMapper.class})
public interface PostMapper {

    PostEntity toEntity(PostDTO postDTO);
    PostDTO toDTO(PostEntity postEntity);
    PostDTO toDTO(PostEntityV2 postEntityV2);

    PostEntityV2 toEntityV2(PostDTO postDTO);

    List<PostDTO> toListDTOwithV2(List<PostEntityV2> postEntityV2List);

    List<PostDTO> toListDTO(List<PostEntity> postEntityList);

    PostEntityV2 toCurrentVersion(PostEntity postEntity);

    List<PostEntityV2> toCurrentVersion(List<PostEntity> postEntityList);
}

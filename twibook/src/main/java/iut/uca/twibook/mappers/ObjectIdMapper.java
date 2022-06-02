package iut.uca.twibook.mappers;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

@Mapper(componentModel = "spring")
@ApplicationScope
public interface ObjectIdMapper {

	default String toString(ObjectId value) {
		return value != null ? value.toHexString() : null;	
	}
	
	default ObjectId toobjectId(String value) {
		return value != null ? new ObjectId(value) : null;
	}
}

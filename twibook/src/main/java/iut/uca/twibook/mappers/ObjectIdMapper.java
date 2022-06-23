package iut.uca.twibook.mappers;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.springframework.web.context.annotation.ApplicationScope;

/***
 * Mapper de ObjectId
 */
@Mapper(componentModel = "spring")
@ApplicationScope
public interface ObjectIdMapper {

	/***
	 * Cette méthode permet de convertir un ObjectId en une String.
	 * @param value L'ObjectId à convertir.
	 * @return Retourne L'ObjectId converti en une String
	 */
	default String toString(ObjectId value) {
		return value != null ? value.toHexString() : null;	
	}

	/***
	 * Cette méthode permet de convertir une String en un ObjectId.
	 * @param value La String à convertir.
	 * @return Retourn La String convertie en un ObjectId.
	 */
	default ObjectId toObjectId(String value) {
		return value != null ? new ObjectId(value) : null;
	}
}

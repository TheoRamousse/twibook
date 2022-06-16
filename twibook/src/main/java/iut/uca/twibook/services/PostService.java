package iut.uca.twibook.services;

import iut.uca.twibook.Status;
import iut.uca.twibook.entities.PostEntity;
import iut.uca.twibook.repositories.PostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public PostEntity findById(ObjectId id){
		PostEntity postEntity = repository.findById(id);
		if(postEntity == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
		}
		return postEntity;
	}

	public List<PostEntity> getPosts(){
		return repository.findAll();
	}

	public Status createPost(PostEntity postEntity){
		Status response;

		if(postEntity.getId() == null) {

			response = Status.CREATED;
		}
		else {
			response = Status.UPDATED;
		}
		repository.save(postEntity);
		return response;
	}

	public Long deletePost(ObjectId postToDelete) {
		return repository.removeById(postToDelete);
	}

	public List<PostEntity> findAllPagined(Integer page, Integer nbElementsPerPage){
		return repository.findAll(PageRequest.of(page, nbElementsPerPage)).getContent();
	}

}

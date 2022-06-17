package iut.uca.twibook.services;

import iut.uca.twibook.Status;
import iut.uca.twibook.entities.comment_entities.CommentEntity;
import iut.uca.twibook.entities.comment_entities.CommentEntityV2;
import iut.uca.twibook.entities.post_entities.PostEntityV2;
import iut.uca.twibook.mappers.PostMapper;
import iut.uca.twibook.repositories.comment_repositories.CommentRepository;
import iut.uca.twibook.repositories.comment_repositories.CommentRepositoryV2;
import iut.uca.twibook.repositories.post_entities.PostRepositoryV2;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import iut.uca.twibook.entities.post_entities.PostEntity;
import iut.uca.twibook.repositories.post_entities.PostRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	@Autowired
	private PostRepositoryV2 repositoryV2;

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private CommentRepositoryV2 commentRepositoryV2;

	public PostEntityV2 findById(ObjectId id){
		PostEntity postEntity = repository.findById(id);
		PostEntityV2 postEntityV2;

		if(postEntity != null){
			postEntityV2 = postMapper.toCurrentVersion(postEntity);
		}
		else {
			postEntityV2 = repositoryV2.findById(id);
		}

		if(postEntityV2 == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
		}
		return postEntityV2;
	}

	public List<PostEntity> getPosts(){
		List<PostEntity> postEntityList = repository.findAll();
		List<PostEntityV2> postEntityV2List = repositoryV2.findAll();
		List<PostEntityV2> temporaryList;

		if(!postEntityList.isEmpty()) {
			temporaryList = postMapper.toCurrentVersion(postEntityList);
			temporaryList.removeAll(postEntityV2List);
			postEntityV2List.addAll(temporaryList);
		}

		return repository.findAll();
	}

	public Status createPost(PostEntity postEntity){
		Status response;

		if(postEntity.getId() != null && repository.existsById(postEntity.getId().toString())) {

			response = Status.UPDATED;
		}
		else {
			response = Status.CREATED;
			postEntity.setSchemaVersion("2");
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

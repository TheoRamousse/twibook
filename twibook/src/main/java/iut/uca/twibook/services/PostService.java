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

	/***
	 * Cette méthode permet de récupérer un post à partir de son Id.
	 * @param id L'Id du post à récupérer.
	 * @return Retourne l'ensemble du post ou une 404 si il n'est pas trouvé.
	 */
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

	/***
	 * Cette méthode permet de récupérer l'ensemble des posts présents en base
	 * @return Retourne l'ensemble des posts convertis dans la version la plus recente.
	 */
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

	/***
	 * Cette méthode permet d'ajouter ou de modifier un post si l'Id a été renseigné.
	 * @param postEntity Le post à ajouter ou modifier.
	 * @return Retourne si le post a été créé ou modifié.
	 */
	public Status createPost(PostEntity postEntity){
	public class EntityAndCodeResult{
		private Status status;
		private PostEntity entity;

		public EntityAndCodeResult(Status status, PostEntity entity){
			this.entity = entity;
			this.status = status;
		}

		public Status getStatus() {
			return status;
		}

		public PostEntity getEntity() {
			return entity;
		}
	}

	public EntityAndCodeResult createPost(PostEntity postEntity){
		Status response;

		if(postEntity.getId() != null && repository.existsById(postEntity.getId().toString())) {

			response = Status.UPDATED;
		}
		else {
			response = Status.CREATED;
			postEntity.setSchemaVersion("2");
		}
		return new EntityAndCodeResult(response, repository.save(postEntity));
	}

	/***
	 * Cette méthode permet de supprimer un post à partir de son Id.
	 * @param postToDelete L'Id du post à supprimer.
	 * @return Retourne un long indiquant si le post a bien été supprimé ou non.
	 */
	public Long deletePost(ObjectId postToDelete) {
		return repository.removeById(postToDelete);
	}

	/***
	 * Cette méthode permet de récupérer des posts sous la forme de page.
	 * @param page Le numéro de la page.
	 * @param nbElementsPerPage Le nombre d'éléments que la page va contenir.
	 * @return Retourne une liste de post.
	 */
	public List<PostEntity> findAllPagined(Integer page, Integer nbElementsPerPage){
		return repository.findAll(PageRequest.of(page, nbElementsPerPage)).getContent();
	}

}

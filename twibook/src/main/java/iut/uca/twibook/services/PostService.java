package iut.uca.twibook.services;

import iut.uca.twibook.Status;
import iut.uca.twibook.entities.PostEntityAndResultCode;
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

import java.time.LocalDate;
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
	public List<PostEntityV2> getPosts(){
		List<PostEntity> postEntityList = repository.findAll();
		List<PostEntityV2> postEntityV2List = repositoryV2.findAll();
		List<PostEntityV2> temporaryList;

		if(!postEntityList.isEmpty()) {
			temporaryList = postMapper.toCurrentVersion(postEntityList);
			temporaryList.removeAll(postEntityV2List);
			postEntityV2List.addAll(temporaryList);
		}

		return postEntityV2List;
	}

	/***
	 * Cette méthode permet d'ajouter ou de modifier un post si l'Id a été renseigné.
	 * @param postEntityv2 Le post à ajouter ou modifier.
	 * @return Retourne si le post a été créé ou modifié, si oui le post ajouté est retourné aussi.
	 */
	public PostEntityAndResultCode createPost(PostEntityV2 postEntityv2){
		Status response;

		if(postEntityv2.getId() != null && repository.existsById(postEntityv2.getId().toString())) {

			response = Status.UPDATED;
		}
		else {
			response = Status.CREATED;
			postEntityv2.setSchemaVersion("2");
		}
		return new PostEntityAndResultCode(response, repositoryV2.save(postEntityv2));
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

package iut.uca.twibook.controller;

import java.util.List;
import java.util.Objects;

import iut.uca.twibook.Status;
import iut.uca.twibook.dtos.PostDTO;
import iut.uca.twibook.entities.PostEntityAndResultCode;
import iut.uca.twibook.entities.post_entities.PostEntity;
import iut.uca.twibook.entities.post_entities.PostEntityV2;
import iut.uca.twibook.mappers.PostMapper;
import iut.uca.twibook.services.PostService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Ce controller permet de gérer l'ensemble des actions en rapport avec les posts.
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    PostMapper mapper;

    /***
     * Ce endpoint permet de récupérer un post à partir de Id.
     * @param id L'Id du post à rechercher dans la base de données.
     * @return Retourne une 200 avec le post dans son intégralité ou une 404 si le post n'a pas été trouvé.
     */
	@GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable ObjectId id) {

        return new ResponseEntity<>(mapper.toDTO(postService.findById(id)), HttpStatus.OK);
    }

    /***
     * Ce endpoint permet d'ajouter un post en base
     * ou de modifier celui présent si un Id est spécifié dans le champ Id du post donné.
     * @param post Le post à ajouter ou modifier.
     * @return Retourne un message indiquant si le post à été modifié (200) ou créé (201).
     */
    @PostMapping
    public ResponseEntity<PostEntityV2> createPost(@RequestBody PostDTO post) {
        if(post.getId() == null || Objects.equals(post.getId(), "0")) {
            post.setId(new ObjectId().toString());
        }
        PostEntityAndResultCode response = postService.createPost(mapper.toEntityV2(post));

        switch (response.getStatus()) {
            case UPDATED: return new ResponseEntity<>(response.getEntity(), HttpStatus.OK);

            default: return new ResponseEntity<>(response.getEntity(), HttpStatus.CREATED);
        }
    }

    /***
     * Ce endpoint permet de supprimer un post à partir de son Id.
     * @param id L'id du post à supprimer.
     * @return Retourne un message indiquant si le post à été supprimé (200),
     * sinon retourne une 404 indiquant que le post n'a pa été trouve.
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePost(@PathVariable ObjectId id) {
        if(postService.deletePost(id) == 1){
            return new ResponseEntity<>("Post deleted", HttpStatus.OK);
        }
        return new ResponseEntity("Post not found", HttpStatus.NOT_FOUND);
    }

    /***
     * Ce endpoint permet de récupérer l'ensemble des post présent dans la base de données
     * ou de les retourner sous la forme d'une pagination.
     * @param nbElementsPerPage Le nombre d'éléments dans la page.
     * @param page Le numéro de la page voulu.
     * @return Retourne tous les joueurs présent en base si le nombre d'éléments ou la page n'a pas été renseigné
     * ou une pagination des éléments selon les paramètres donnés
     * ou une 204 si aucun élément n'a été retourné.
     */
    @GetMapping
    public ResponseEntity<List<PostDTO>> getPostsPagined(@RequestParam(required = false) Integer nbElementsPerPage, @RequestParam(required = false) Integer page) {

        List<PostDTO> postDTOList;

        if(nbElementsPerPage != null && page != null){
            postDTOList = mapper.toListDTO(postService.findAllPagined(page, nbElementsPerPage));
        }
        else {
            postDTOList = mapper.toListDTO(postService.getPosts());
        }

        if (postDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(postDTOList, HttpStatus.OK);
        }
    }
}

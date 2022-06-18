package iut.uca.twibook.controller;

import iut.uca.twibook.Status;
import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.mappers.UserMapper;
import iut.uca.twibook.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/***
 * Ce controller permet de gérer l'ensemble des actions en rapport avec les utilisateurs.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    /***
     * Ce endpoint permet de récupérer un utilisateur à partir de son Id.
     * @param id L'Id du joueur à récuperer.
     * @return Retourne une 200 avec le joueur dans son intégralité
     * ou une 404 indiquant que le joueur n'a pas été trouvé.
     */
	@GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(mapper.toDTO(userService.findById(id)), HttpStatus.OK);
    }

    /***
     * Ce endpoint permet de récupérer l'ensemble des utilisateurs présent en base de données
     * ou de récupérer un utilisateur à partir du nick name si il est donné en paramètre.
     * @param nickName Le nick name de l'utilisateur à chercher.
     * @return Retourne une 200 et l'ensemble des utilisateurs si des utilisateurs sont trouvés
     * sinon une 204 avec un contenu vide
     * ou si un nick name à été spécifié, une 200 avec l'ensemble des données du joueur
     * ou une 404 si le joueur n'a pas été trouvé.
     */
    @GetMapping(value = "/nickname/{nickName}")
    public ResponseEntity<UserDTO> getUserByNickName(@PathVariable String nickName) {

        return new ResponseEntity<>(mapper.toDTO(userService.findByNickName(nickName)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(@RequestParam(required = false) String nickName) {

        if(nickName != null) {
            return new ResponseEntity<>(mapper.toListDTO(Collections.singletonList(userService.findByNickName(nickName))), HttpStatus.OK);
        }

        List<UserDTO> userDTOList = mapper.toListDTO(userService.getUsers());

        if(userDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    /***
     * Ce endpoint permet d'ajouter un utilisateur en base
     * ou de supprimer celui présent si l'Id est spécifié.
     * @param user Le joueur à ajouter ou modifier.
     * @return Retourne un message indiquant si le joueur a été ajouté (201) ou modifié (200).
     */
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO user) {
        if(user.getId() == null || user.getId().equals("0")) {
            user.setId((new ObjectId()).toString());
        }
        Status response = userService.createUser(mapper.toEntity(user));

        switch (response) {
            case UPDATED: return new ResponseEntity<>("User updated", HttpStatus.OK);

            default: return new ResponseEntity<>("User created", HttpStatus.CREATED);
        }
    }

    /***
     * Ce endpoint permet de supprimer un utilisateur à partir de son Id.
     * @param id L'Id de l'utilisateur à supprimer.
     * @return Retourne une 200 si l'utilisateur a été supprimé
     * ou une 404 si aucun utilisateur n'a été trouvé.
     */
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ObjectId id) {
        if(userService.deleteUser(id) == 1){
            return new ResponseEntity<>("User deleted", HttpStatus.OK);
        }
        return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
    }
}

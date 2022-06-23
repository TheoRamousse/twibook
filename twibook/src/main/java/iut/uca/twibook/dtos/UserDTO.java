package iut.uca.twibook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/***
 * Objet utilisateur qui sera renvoyé à en retour d'une requète.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    /***
     * Identifiant de l'utilisateur.
     */
    private String id;

    /***
     * Prenom de l'utilisateur.
     */
    private String firstName;

    /***
     * Nom de l'utilisateur.
     */
    private String lastName;

    /***
     * Psueudo de l'utilisateur.
     */
    private String nickName;

    /***
     * Image de l'utilisateur.
     */
    private String imageUrl;

    /***
     * Date de naissance de l'utilisateur.
     */
    private LocalDate birthDate;

    /***
     * Email de l'utilisateur.
     */
    private String email;

    /***
     * Mot de passe de l'utilisateur.
     */
    private String password;

    /***
     * Liste des Id des posts posté par l'utilisateur.
     */
    private List<String> posts;

    /***
     * Liste des voitures de l'utilisateur.
     */
    private List<CarDTO> cars;

}



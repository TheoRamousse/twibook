# Twibook en quelques mots
Twibook est un réseau social pour les fans de grosses cylindrées. Nous avons pour ambition de réunir les amateurs de beaux bolides à un même endroit afin qu'ils puissent échanger au sujet de leur passion avec des posts pouvant contenir du texte et des photos. Le réseau social est inspiré de Facebook et de Twitter. Ainsi, les utilisateurs pourront ajouter des posts à leur mur et les autres utilisateurs auront la possibilité de les commenter. 

## Contexte de création du site web

### Contraintes techniques imposées

- Une limite de 4 photos par post a été fixée afin d'éviter d'avoir des photos illisibles
- Lorsqu'un utilisateur visionne le mur d'un autre utilisateur, les posts sont "réduits". Cela signifie que seul le post est visible ainsi que le premier commentaire publié sous le post
- Lorsqu'un utilisateur clique sur un post, celui-ci se "déplie". Cela signifie que l'ensemble des commentaires seront alors visibles en plus du contenu du post.
- Pour des questions de quota serveur, aucune image n'est enregistré dans le stockage du site, celles-ci sont uploadés directement depuis le web grâce à leur URL

Voici un sketch montrant ce que l'on appelle un post "réduit" : 
![Post réduit](Documentation/Images/Post réduit.PNG)

Voici un sketch montrant ce que l'on appelle un post "déplié" : 
![Post déplié](Documentation/Images/Post déplié.PNG)

### Techologies utilisées

Dans le cadre du cours de "Client-Serveur", sera la partie back sera développée ainsi qu'une application console pour valider le fonctionnement : 
- Le back sera développé en JAVA - Spring Boot
- L'application console sera développée en JAVA
- La couche de persistance des données sera gérée par une base de données MongoDB

## Réflexion tecnique préliminaire

### MongoDB

Après avoir réfléchi aux différentes contraintes techniques que nous nous imposons pour la réalisation du projet, nous avons retranscrit cela sous la forme d'un diagramme UML. Les contraintes techniques sont explicitées grâce aux cardinalités du diagramme :

![Diagramme UML pour l'architecture de la MongoDB](Documentation/Images/Diagramme UML préliminaire.png)

Nous avons décidé de rajouter de l'incoporation dans les objets suivants : 
- Comment : Permet d'afficher le pseudo et l'utilisateur et son avatar sans avoir à faire une sous requête pour récupérer ces attributs
- Post : Permet d'afficher le premier commentaire du post sans voir à faire une sous requête pour le récupérer 

### Spring Boot

TODO

### JAVA

TODO


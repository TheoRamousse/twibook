import { Injectable } from '@angular/core';
import { Post } from '../model/Post';
import { Comment } from '../model/Comment';
import { User } from '../model/User';
import { PersistenceTemplateService } from './persistence-template.service';
import { Car } from '../model/Car';
import { Color } from '../model/Color';
import { BehaviorSubject, Observable } from 'rxjs';
import { PostFromApi } from '../model/PostFromApi';
import { UserFromApi } from '../model/UserFromApi';
import { CommentFromApi } from '../model/CommentFromApi';

@Injectable({
  providedIn: 'root'
})
export class StubService extends PersistenceTemplateService {

  private getNextCommentId(): string {
    var maxId = 0;
    this.comments.forEach(comment => {
      if (Number(comment.id) > maxId) {
        maxId = Number(comment.id);
      }
    });
    return (maxId + 1).toString()
  }

  private getNextPostId(): string {
    var maxId = 0;
    this.posts.forEach(post => {
      if (Number(post.id) > maxId) {
        maxId = Number(post.id);
      }
    });
    return (maxId + 1).toString()
  }

  addNewComment(comment: Comment): Observable<CommentFromApi> {
    comment.id = this.getNextCommentId()
    this.comments.push(comment)
    return new BehaviorSubject<CommentFromApi>(new CommentFromApi(comment))
  }
  addNewPost(post: Post): Observable<PostFromApi> {
    post.id = this.getNextPostId()
    this.posts.push(post)
    return new BehaviorSubject<PostFromApi>(new PostFromApi(post))
  }

  updatePost(post: Post): Observable<PostFromApi> {
    this.posts.forEach(p => {
      if (p.id == post.id) {
        p = post
      }
    })

    return new BehaviorSubject<PostFromApi>(new PostFromApi(post))
  }

  private posts = [
    new Post("1", "Ceci est un post de test, le texte fournit n'a donc aucun intérêt ;)", new Date(Date.now()), "https://ultimatecourses.com/assets/category/angular-2052c478f3fcf0adc1c1c5aad5a4d9fe46a896ccda52ee6b8383b687b0c61042.svg", "Toto", new Date(Date.now()), "C'est vrai que ce post n'a aucun intérêt !!!", "uneAutreImage", "Titi", "https://img4.autodeclics.com/photos/11/324255/hd-diapo-jacky-tuning---photos-de-cr%C3%A9ations-extr%C3%AAmes-plus-ou-moins-r%C3%A9ussies.jpg", new Array("1", "2", "3")),
    new Post("2", "Lorem ipsum dolor sit amet. Et vero omnis et earum iure aut tempora internos sed internos odio et nihil tempora. Eos aperiam optio vel velit tempore est inventore dolores id sunt expedita et magnam voluptatum et consectetur asperiores qui iusto adipisci.", new Date(Date.now()), "https://www.loremipzum.com/img/logo.webp", "Inspecteur Gadget", new Date(Date.now()), "C'est vrai que ce post n'a aucun intérêt !!!", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWvHjxafZU25oIbo4hxp4XNCBzA3sYK5A6qjvbwcZIAW3u9_3dX0-hpzrXdegBggTURic&usqp=CAU", "Tutu", "https://img4.autodeclics.com/photos/11/324255/hd-diapo-jacky-tuning---photos-de-cr%C3%A9ations-extr%C3%AAmes-plus-ou-moins-r%C3%A9ussies.jpg", new Array("1", "2", "3")),
    new Post("3", "A autem nulla eos molestias consequatur hic fugit molestiae. Ut Quis voluptate eum repellat iure aut commodi illo. Qui architecto repellendus et maiores ullam 33 iure dolorum ex temporibus est ducimus asperiores?", new Date(Date.now()), "https://secure.gravatar.com/avatar/88ed41fb775d4b2c7eb3c428ec9395fd?s=80&d=identicon", "Pikachu", new Date(Date.now()), "C'est vrai que ce post n'a aucun intérêt !!!", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWvHjxafZU25oIbo4hxp4XNCBzA3sYK5A6qjvbwcZIAW3u9_3dX0-hpzrXdegBggTURic&usqp=CAU", "Tata", "https://img4.autodeclics.com/photos/11/324255/hd-diapo-jacky-tuning---photos-de-cr%C3%A9ations-extr%C3%AAmes-plus-ou-moins-r%C3%A9ussies.jpg"),
    new Post("4", "A sunt veniam in ullam fugit rem perferendis nostrum. Et rerum esse cum fugit odio quo nemo omnis eos praesentium voluptatem! Et cupiditate expedita sed mollitia cupiditate quo repellat quisquam est autem tempora ut ipsa accusamus cum debitis aspernatur et voluptatem iusto.", new Date(Date.now()), "https://gitlab.iut-clermont.uca.fr/uploads/-/system/user/avatar/418/avatar.png?width=40", "Gormiti", new Date(Date.now()), "C'est vrai que ce post n'a aucun intérêt !!!", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWvHjxafZU25oIbo4hxp4XNCBzA3sYK5A6qjvbwcZIAW3u9_3dX0-hpzrXdegBggTURic&usqp=CAU", "Tyty", ""),
  ];

  private comments = [
    new Comment("1", "Lorem ipsum dolor sit amet. Et vero omnis et earum iure aut tempora internos sed internos odio et nihil tempora.", new Date(Date.now()), "Toto", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWvHjxafZU25oIbo4hxp4XNCBzA3sYK5A6qjvbwcZIAW3u9_3dX0-hpzrXdegBggTURic&usqp=CAU"),
    new Comment("2", "Lorem ipsum dolor sit amet. Et vero omnis et earum iure aut tempora internos sed internos odio et nihil tempora.", new Date(Date.now()), "Toto", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWvHjxafZU25oIbo4hxp4XNCBzA3sYK5A6qjvbwcZIAW3u9_3dX0-hpzrXdegBggTURic&usqp=CAU"),
    new Comment("3", "Lorem ipsum dolor sit amet. Et vero omnis et earum iure aut tempora internos sed internos odio et nihil tempora.", new Date(Date.now()), "Toto", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWvHjxafZU25oIbo4hxp4XNCBzA3sYK5A6qjvbwcZIAW3u9_3dX0-hpzrXdegBggTURic&usqp=CAU")
  ];

  private users = [
    new User("1", "Jean", "Edward", "toto", "babar@hotmail.fr", "$2a$10$h.BaJZk.I3yCZkW2H2qPAeIaouZYxS06kOyQvCEOfD/C3VBqM1JUq", "https://asset1.replay.fr/photos/3d0/3d07f31980ca05886d33fc5c4123ab11.large.jpg", new Date(Date.now()), new Array(new Car("2", "206", "Peugeot", Color.Red)), new Array("1", "2", "3")),
  ]

  override getUsers(): Observable<User[]> {
    return new BehaviorSubject<User[]>(this.users);
  }

  override getUserByIdentifiant(identifiant: string): Observable<UserFromApi> {
    return new BehaviorSubject<UserFromApi>(new UserFromApi(this.users.find(element => element.email == identifiant || element.nickName == identifiant)!));
  }

  override getUserById(id: string): Observable<User> {
    return new BehaviorSubject<User>(this.users.find(element => element.id == id)!);
  }

  override getPosts(): Observable<Post[]> {
    return new BehaviorSubject<Post[]>(this.posts);
  }

  override getPostById(id: string): Observable<Post> {
    return new BehaviorSubject<Post>(this.posts.find(element => element.id == id)!);
  }

  override getCommentById(id: string): Observable<Comment> {
    return new BehaviorSubject<Comment>(this.comments.find(element => element.id == id)!)
  }

  escapeRegExp(string) {
    return string.replace(/[^a-zA-Z ]/g, '\\$&'); // $& means the whole matched string
  }

  addNewUser(user: User) {
    this.users.push(user);
  }

  override getPostsPagined(current_page: number, per_page_items: number): Observable<Array<PostFromApi>> {
    let page = current_page || 1,
      per_page = per_page_items || 1,
      offset = (page - 1) * per_page,

      paginatedItems = this.posts.slice(offset).slice(0, per_page_items)

    return new BehaviorSubject<PostFromApi[]>(paginatedItems.map(post => {
      return new PostFromApi(post);
    }))
  }
}

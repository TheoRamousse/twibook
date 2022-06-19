import { Injectable } from '@angular/core';
import { Comment } from '../model/Comment';
import { Post } from '../model/Post';
import { User } from '../model/User';
import { PersistenceTemplateService } from './persistence-template.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ValueAccessor } from '@ionic/angular/directives/control-value-accessors/value-accessor';
import { Observable } from 'rxjs';
import { PostFromApi } from '../model/PostFromApi';
import { UserFromApi } from '../model/UserFromApi';
import { CommentFromApi } from '../model/CommentFromApi';

@Injectable({
  providedIn: 'root'
})

export class ApiClientService extends PersistenceTemplateService {

  constructor(private http: HttpClient) {
    super()
  }


  override getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(environment.apiUrl + 'posts')
  }
  override getPostById(id: string): Observable<Post> {

    return this.http.get<Post>(environment.apiUrl + 'posts/' + id)
  }
  override getCommentById(id: string): Observable<Comment> {
    return this.http.get<Comment>(environment.apiUrl + 'comments/' + id)
  }
  override getUserById(id: string): Observable<User> {
    return this.http.get<User>(environment.apiUrl + 'users/' + id)
  }
  override getUsers(): Observable<User[]> {
    return this.http.get<User[]>(environment.apiUrl + 'users')
  }

  override getPostsPagined(current_page: number, per_page_items: number): Observable<PostFromApi[]> {
    return this.http.get<Array<PostFromApi>>(environment.apiUrl + 'posts?page=' + current_page + '&nbElementsPerPage=' + per_page_items)
  }


  override getUserByIdentifiant(identifiant: string): Observable<UserFromApi> {
    return this.http.get<UserFromApi>(environment.apiUrl + 'users/nickname/' + identifiant)
  }
  override addNewUser(user: User): void {
    const headers = { 'content-type': 'application/json' }
    this.http.post(environment.apiUrl + 'users', {
      firstName: user.firstName,
      lastName: user.lastName,
      id: user.id,
      nickName: user.nickName,
      email: user.email,
      password: user.hashedPassword,
      birthDate: null,
      posts: [],
      cars: [],
      imageUrl: user.imageUrl,

    }, { 'headers': headers }).subscribe()
  }
  override addNewComment(comment: Comment): Observable<CommentFromApi> {
    const headers = { 'content-type': 'application/json' }
    return this.http.post<CommentFromApi>(environment.apiUrl + 'comments/', {
      id: comment.id,
      text: comment.text,
      publicationDate: comment.publicationDate,
      userNickName: comment.userNickName,
      userImageUrl: comment.userImageUrl,
    }, { 'headers': headers });
  }
  override addNewPost(post: Post): Observable<PostFromApi> {
    const headers = { 'content-type': 'application/json' }
    return this.http.post<PostFromApi>(environment.apiUrl + 'posts/', {
      id: post.id,
      text: post.text,
      postImage: post.imageUrl,
      publicationDate: post.publicationDate,
      firstCommentText: post.firstCommentText,
      firstCommentUserImageUrl: post.firstCommentUserImageUrl,
      firstCommentUserNickName: post.firstCommentUserNickName,
      comments: post.idComments

    }, { 'headers': headers });
  }
  override updatePost(post: Post): Observable<PostFromApi> {
    debugger
    const headers = { 'content-type': 'application/json' }
    return this.http.post<PostFromApi>(environment.apiUrl + 'posts/', {
      id: post.id,
      text: post.text,
      postImage: post.imageUrl,
      publicationDate: post.publicationDate,
      firstCommentText: post.firstCommentText,
      firstCommentUserImageUrl: post.firstCommentUserImageUrl,
      firstCommentUserNickName: post.firstCommentUserNickName,
      comments: post.idComments

    }, { 'headers': headers });
  }

}

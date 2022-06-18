import { Injectable } from '@angular/core';
import { Post } from '../model/Post';
import { User } from '../model/User';
import { Comment } from '../model/Comment';
import { Observable } from 'rxjs';
import { PostFromApi } from '../model/PostFromApi';

@Injectable({
  providedIn: 'root'
})

export abstract class PersistenceTemplateService {

  abstract getPosts(): Observable<Array<Post>>;
  abstract getPostsPagined(current_page: number, per_page_items: number): Observable<Array<PostFromApi>>;
  abstract getPostById(id: string): Observable<Post>;
  abstract getCommentById(id: string): Observable<Comment>;
  abstract getUserById(id: string): Observable<User>;
  abstract getUsers(): Observable<Array<User>>;
  abstract getUserByIdentifiant(identifiant: string): Observable<User>;
  abstract addNewUser(user: User): void;
  abstract addNewComment(comment: Comment): Observable<Comment>;
  abstract addNewPost(post: Post): void;
  abstract updatePost(post: Post): void;
}

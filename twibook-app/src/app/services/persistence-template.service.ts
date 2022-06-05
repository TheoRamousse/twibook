import { Injectable } from '@angular/core';
import { Post } from '../model/Post';
import { User } from '../model/User';
import { Comment } from '../model/Comment';

@Injectable({
  providedIn: 'root'
})

export abstract class PersistenceTemplateService {

  abstract getPosts(): Array<Post>;
  abstract getPostsPagined(current_page: number, per_page_items: number): Array<Post>;
  abstract getPostById(id: string): Post;
  abstract getCommentById(id: string): Comment;
  abstract getUserById(id: string): User;
  abstract getUsers(): Array<User>;
  abstract getUserByIdentifiant(identifiant: string): User;
  abstract addNewUser(user: User): void;
  abstract addNewComment(comment: Comment): Comment;
  abstract addNewPost(post: Post): void;
  abstract updatePost(post: Post): void;
}

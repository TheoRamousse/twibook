import { Injectable } from '@angular/core';
import { Comment } from '../model/Comment';
import { Post } from '../model/Post';
import { User } from '../model/User';
import { PersistenceTemplateService } from './persistence-template.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ValueAccessor } from '@ionic/angular/directives/control-value-accessors/value-accessor';

@Injectable({
  providedIn: 'root'
})

export class ApiClientService extends PersistenceTemplateService {
  getPostsPagined(current_page: number, per_page_items: number): Post[] {
    throw new Error('Method not implemented.');
  }

  constructor(private http: HttpClient) {
    super()
  }


  getPosts(): Post[] {
    let value: Post[] = null;
    this.http.get<Post[]>(environment.apiUrl+'posts').subscribe(posts => value=posts);
    return value;
  }
  getPostById(id: string): Post {
    let value: Post = null;

    this.http.get<Post>(environment.apiUrl+'posts/'+id);
    return value;
  }
  getCommentById(id: string): Comment {
    let value: Comment = null;
    this.http.get<Comment>(environment.apiUrl+'comments/'+id).subscribe(comment => value=comment);
    return value;
  }
  getUserById(id: string): User {
    let value: User = null;
    this.http.get<User>(environment.apiUrl+'users/'+id).subscribe(user => value=user);
    return value;
  }
  getUsers(): User[] {
    let value: User[] = null;
    this.http.get<User[]>(environment.apiUrl+'users').subscribe(users => value=users);
    return value;
  }
  getUserByIdentifiant(identifiant: string): User {
    let value: User = null;
    this.http.get<User>(environment.apiUrl+'users?nickName='+identifiant).subscribe(user => value=user);
    return value;
  }
  addNewUser(user: User): void {
    this.http.post(environment.apiUrl+'users/',user);
  }
  addNewComment(comment: Comment): Comment {
    let value: Comment = null;
    this.http.post<Comment>(environment.apiUrl+'comments/',comment).subscribe(c => value = c);
    return value;
  }
  addNewPost(post: Post): void {
    this.http.post(environment.apiUrl+'posts/',post);
  }
  updatePost(post: Post): void {
    this.http.put(environment.apiUrl+'posts/',post);
  }

}

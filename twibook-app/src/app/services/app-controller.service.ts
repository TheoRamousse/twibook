import { Injectable } from '@angular/core';
import { User } from '../model/User';
import * as bcrypt from 'bcryptjs';
import { PersistenceTemplateService } from './persistence-template.service';
import { Post } from '../model/Post';
import { Comment } from '../model/Comment';
import { LocalStorageKeys } from '../model/LocalStorageKeys';
import { Observable } from 'rxjs';
import { PostFromApi } from '../model/PostFromApi';
import { UserFromApi } from '../model/UserFromApi';

@Injectable({
  providedIn: 'root',
})
export class AppControllerService {

  constructor(private pers: PersistenceTemplateService) { }

  public tryConnect(id: string, password: string): Observable<UserFromApi> {
    return this.pers.getUserByIdentifiant(id)

  }

  public logout() {
    localStorage.removeItem(LocalStorageKeys.user)
  }

  public registerUser(email: string, password: string, nickName: string, firstName: string, lastName: string) {
    var hashedPassword = bcrypt.hashSync(password, 10);
    this.pers.addNewUser(new User("0", firstName, lastName, nickName, email, hashedPassword));
  }

  public getCommentById(id: string) {
    console.log("toto")
    return this.pers.getCommentById(id)
  }

  public get user() {
    var userAsString = localStorage.getItem(LocalStorageKeys.user)
    if (userAsString == null) {
      return null
    }

    var result = JSON.parse(userAsString)
    return new User(result.id, result.firstName, result.lastName, result.nickName, result.email, result.password, result.imageUrl, result.birthDate, result.cars, result.posts);
  }

  public addNewComment(referencedPost: Post, newComment: Comment) {
    this.pers.addNewComment(newComment).subscribe(commentReturned => {
      if (referencedPost.idComments.length == 0) {
        referencedPost.firstCommentPublicationDate = newComment.publicationDate
        referencedPost.firstCommentText = newComment.text
        referencedPost.firstCommentUserImageUrl = newComment.userImageUrl
        referencedPost.firstCommentUserNickName = newComment.userNickName
      }

      referencedPost.addComment(commentReturned.id)

      this.pers.updatePost(referencedPost).subscribe()
    })
  }

  public addNewPost(post: Post): Observable<PostFromApi> {
    return this.pers.addNewPost(post)
  }

  public getPostsPagined(page: number, count: number): Observable<Array<PostFromApi>> {
    return this.pers.getPostsPagined(page, count)
  }

  public getUserByNickName(nickName: string): Observable<UserFromApi> {
    return this.pers.getUserByIdentifiant(nickName)
  }
}

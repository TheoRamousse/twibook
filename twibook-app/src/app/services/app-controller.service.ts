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
    debugger
    var hashedPassword = bcrypt.hashSync(password, 10);
    this.pers.addNewUser(new User("0", firstName, lastName, nickName, email, hashedPassword));
  }

  public getCommentById(id: string) {
    return this.pers.getCommentById(id)
  }

  public get user() {
    var userAsString = localStorage.getItem(LocalStorageKeys.user)
    if (userAsString == null) {
      return null
    }

    var result = JSON.parse(userAsString)
    return new User(result._id, result._firstName, result._lastName, result._nickName, result._email, result._hashedPwd, result._imageUrl, result._birthDate, result._cars, result._idPosts);
  }

  public addNewComment(referencedPost: Post, newComment: Comment) {
    debugger
    this.pers.addNewComment(newComment).subscribe(commentReturned => {
      if (referencedPost.idComments.length == 0) {
        referencedPost.firstCommentPublicationDate = newComment.publicationDate
        referencedPost.firstCommentText = newComment.text
        referencedPost.firstCommentUserImageUrl = newComment.userImageUrl
        referencedPost.firstCommentUserNickName = newComment.userNickName
      }

      referencedPost.idComments.push(commentReturned.id)

      this.pers.updatePost(referencedPost)
    })
  }

  public addNewPost(post: Post) {
    this.pers.addNewPost(post)
  }

  public getPostsPagined(page: number, count: number): Observable<Array<PostFromApi>> {
    return this.pers.getPostsPagined(page, count)
  }

  public getUserByNickName(nickName: string): Observable<UserFromApi> {
    return this.pers.getUserByIdentifiant(nickName)
  }
}

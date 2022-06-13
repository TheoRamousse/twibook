import { Injectable } from '@angular/core';
import { User } from '../model/User';
import * as bcrypt from 'bcryptjs';
import { PersistenceTemplateService } from './persistence-template.service';
import { Post } from '../model/Post';
import { Comment } from '../model/Comment';
import { LocalStorageKeys } from '../model/LocalStorageKeys';

@Injectable({
  providedIn: 'root',
})
export class AppControllerService {
  private connectedUser: User = null;

  constructor(private pers: PersistenceTemplateService) { }

  public tryConnect(id: string, password: string) {
    var userFound = this.pers.getUserByIdentifiant(id)
    if (userFound == null) {
      throw new Error("Identifiant inconnu")
    }

    bcrypt.compare(password, userFound.hashedPassword, (err, result) => {
      if (result) {
        localStorage.setItem(LocalStorageKeys.user, JSON.stringify(userFound))
        return
      }
    });

    if (this.user == null) {
      throw new Error("Mot de passe incorrect")
    }
  }

  public logout() {
    localStorage.removeItem(LocalStorageKeys.user)
  }

  public registerUser(email: string, password: string, nickName: string, firstName: string, lastName: string) {
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
    var commentReturned = this.pers.addNewComment(newComment)
    referencedPost.idComments.push(commentReturned.id)
    this.pers.updatePost(referencedPost)
  }

  public getPostsPagined(page: number, count: number): Array<Post> {
    return this.pers.getPostsPagined(page, count)
  }
}

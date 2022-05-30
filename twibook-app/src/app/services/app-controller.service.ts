import { Injectable } from '@angular/core';
import { User } from '../model/User';
import * as bcrypt from 'bcryptjs';
import { PersistenceTemplateService } from './persistence-template.service';

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
        this.connectedUser = userFound
        return
      }
    });

    if (this.connectedUser == null) {
      throw new Error("Mot de passe incorrect")
    }
  }

  public registerUser(email: string, password: string, nickName: string, firstName: string, lastName: string) {
    var hashedPassword = bcrypt.hashSync(password, 10);
    this.pers.addNewUser(new User("0", firstName, lastName, nickName, email, hashedPassword));
  }

  public get user() {
    return this.connectedUser;
  }
}

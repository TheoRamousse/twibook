import { Component } from '@angular/core';
import { User } from '../../model/User';
import { AppControllerService } from '../../services/app-controller.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-inscription',
  templateUrl: 'inscription.page.html',
  styleUrls: ['inscription.page.scss']
})
export class InscriptionPage {
  private password: string = "";
  private passwordConfirmation: string = "";
  private nickName: string = "";
  private firstName: string = "";
  private lastName: string = "";
  private email: string = "";
  private errorMessage = "";

  constructor(private controlleur: AppControllerService, private router: Router) { }

  checkPasswordComplexity(password: string): boolean {
    if (password.length < 8) {
      this.errorMessage = "Le mot de passe doit contenir au moins 8 caractères";
      return false;
    }
    if (password.search(/[a-z]/i) < 0) {
      this.errorMessage = "Le mot de passe doit contenir au moins une minuscule";
      return false;
    }
    if (password.search(/[A-Z]/i) < 0) {
      this.errorMessage = "Le mot de passe doit contenir au moins une majuscule";
      return false;
    }
    if (password.search(/[0-9]/i) < 0) {
      this.errorMessage = "Le mot de passe doit contenir au moins un chiffre";
      return false;
    }
    return true;
  }

  onSubmit() {
    if (this.password != this.passwordConfirmation) {
      this.errorMessage = "Les mots de passe ne correspondent pas";
    }

    //check complexity password
    else if (!this.checkPasswordComplexity(this.password)) {
      this.errorMessage = "Le mot de passe n'est pas assez complexe";
    }
    else {
      this.controlleur.getUserByNickName(this.nickName).subscribe(user => {
        this.errorMessage = "Ce pseudo est déjà utilisé";
      }, error => {
        if (error.status == 404) {
          this.controlleur.registerUser(this.email, this.password, this.nickName, this.firstName, this.lastName);
          this.errorMessage = "";
          this.router.navigate(['tabs/connection']);
        }
        else {
          this.errorMessage = "Une erreur est survenue";
        }
      })
    }

  }
}

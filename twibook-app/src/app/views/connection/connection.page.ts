import { Component } from '@angular/core';
import * as bcrypt from 'bcryptjs';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { AppControllerService } from '../../services/app-controller.service';
import { LocalStorageKeys } from '../../model/LocalStorageKeys';

@Component({
  selector: 'app-connection',
  templateUrl: 'connection.page.html',
  styleUrls: ['connection.page.scss']
})
export class ConnectionPage {
  private errorMessage: string = null
  private identifiant: string
  private password: string

  constructor(private controlleur: AppControllerService, private router: Router) {
  }

  onTryLogin() {
    var self = this

    this.controlleur.tryConnect(this.identifiant, this.password).subscribe(userFound => {
      if (userFound == null) {
        this.errorMessage = "Identifiant inconnu"
      }

      var result = bcrypt.compareSync(self.password, userFound.password);

      if (result) {
        localStorage.setItem(LocalStorageKeys.user, JSON.stringify(userFound))
        this.errorMessage = ""
        this.router.navigate(['tabs/timeline']);
        return
      }
      else {
        this.errorMessage = "Mot de passe incorrect"
      }

    }, error => {
      this.errorMessage = "Identifiant inconnu"
    })
  }

  onNavigateRegister() {
    this.router.navigate(['tabs/inscription'])
  }
}

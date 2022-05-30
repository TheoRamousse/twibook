import { Component } from '@angular/core';
import { PersistenceTemplateService } from '../persistence-template.service';
import { StubService } from '../stub.service';
import * as bcrypt from 'bcryptjs';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-connection',
  templateUrl: 'connection.page.html',
  styleUrls: ['connection.page.scss'],
  providers: [
    { provide: PersistenceTemplateService, useClass: StubService },
  ]
})
export class ConnectionPage {
  private pers: PersistenceTemplateService

  private identifiant: string
  private password: string
  private errorMessage: string = null

  constructor(pers: PersistenceTemplateService, private router: Router) {
    this.pers = pers
  }

  onTryLogin() {

    var result = this.pers.getUserByIdentifiant(this.identifiant)
    const salt = bcrypt.genSaltSync(10);
    var passHashed = bcrypt.hashSync(this.password, 10);
    if (result == null) {
      this.errorMessage = "Identifiant inconnu"
    }
    else if (passHashed != this.password) {
      this.errorMessage = "Mot de passe incorrect"
    }
    else{
      this.router.navigate(['/tabs/inscription']);
    }
  }

}

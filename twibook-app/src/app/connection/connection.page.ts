import { Component } from '@angular/core';
import { PersistenceTemplateService } from '../persistence-template.service';
import { StubService } from '../stub.service';

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

  constructor(pers: PersistenceTemplateService) {
    this.pers = pers
  }

  onTryLogin() {
    var result = this.pers.getUserByIdentifiant(this.identifiant)
    if (result == null) {
      alert("Identifiant inconnu")
    }
    else if (result.hashedPassword != this.password) {
      alert("Mot de passe incorrect")
    }
  }

}

import { Component } from '@angular/core';
import * as bcrypt from 'bcryptjs';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { AppControllerService } from '../../services/app-controller.service';

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
    console.log(this.password)
    try {
      this.controlleur.tryConnect(this.identifiant, this.password)
      this.errorMessage = ""
      this.router.navigate(['tabs/timeline']);
    } catch (error) {
      this.errorMessage = error.message
    }
  }

  onNavigateRegister() {
    this.router.navigate(['tabs/inscription'])
  }
}

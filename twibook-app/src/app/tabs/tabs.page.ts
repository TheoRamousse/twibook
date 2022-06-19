import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppControllerService } from '../services/app-controller.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tabs',
  templateUrl: 'tabs.page.html',
  styleUrls: ['tabs.page.scss']
})
export class TabsPage {
  user = this.controller
  isActiveAcceuil = true;
  isActiveSetting = false;
  isActivePost = false;
  isActiveInscription = false;
  isActiveDeco = false;
  constructor( public router: Router,private controller: AppControllerService)  {}

  navigateToInscription(){
    this.isActiveAcceuil = false;
    this.isActiveSetting = false;
    this.isActivePost = false;
    this.isActiveInscription = true;
    this.isActiveDeco=false;
    this.router.navigateByUrl('/tabs/inscription')
  }

  navigateToPost(){
    this.isActiveAcceuil = false;
    this.isActiveSetting = false;
    this.isActivePost = true;
    this.isActiveInscription = false;
    this.isActiveDeco=false;
    this.router.navigateByUrl('/tabs/timeline')
  }

  navigateToAcceuil(){
    this.isActiveAcceuil = true;
    this.isActiveSetting = false;
    this.isActivePost = false;
    this.isActiveInscription = false;
    this.isActiveDeco=false;
    this.router.navigateByUrl('/tabs/connection')
  }

  navigateToSetting(){
    this.isActiveAcceuil = false;
    this.isActiveSetting = true;
    this.isActivePost = false;
    this.isActiveInscription = false;
    this.isActiveDeco=false;
    this.router.navigateByUrl('/tabs/edition-profile')
  }

  deconnexion(){
    this.isActiveDeco=true;
    this.isActiveAcceuil = false;
    this.isActiveSetting = false;
    this.isActivePost = false;
    this.isActiveInscription = false;
    this.controller.logout();
  }

}

import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tabs',
  templateUrl: 'tabs.page.html',
  styleUrls: ['tabs.page.scss']
})
export class TabsPage {
  isActiveAcceuil = true;
  isActiveSetting = false;
  isActivePost = false;
  isActiveInscription = false;
  constructor( public router: Router)  {}

  navigateToInscription(){
    this.isActiveAcceuil = false;
    this.isActiveSetting = false;
    this.isActivePost = false;
    this.isActiveInscription = true;
    this.router.navigateByUrl('/tabs/inscription')
  }

  navigateToPost(){
    this.isActiveAcceuil = false;
    this.isActiveSetting = false;
    this.isActivePost = true;
    this.isActiveInscription = false;
    this.router.navigateByUrl('/tabs/post')
  }

  navigateToAcceuil(){
    this.isActiveAcceuil = true;
    this.isActiveSetting = false;
    this.isActivePost = false;
    this.isActiveInscription = false;
    this.router.navigateByUrl('/tabs/connection')
  }

  navigateToSetting(){
    this.isActiveAcceuil = false;
    this.isActiveSetting = true;
    this.isActivePost = false;
    this.isActiveInscription = false;
    this.router.navigateByUrl('/tabs/setting')
  }

}

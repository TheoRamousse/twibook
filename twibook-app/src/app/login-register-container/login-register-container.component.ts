import { Component, OnInit, ContentChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-login-register-container',
  templateUrl: './login-register-container.component.html',
  styleUrls: ['./login-register-container.component.scss'],
})
export class LoginRegisterContainerComponent implements OnInit {

  @ContentChild('body') body?: ElementRef;

  constructor() { }

  ngOnInit() {}

}

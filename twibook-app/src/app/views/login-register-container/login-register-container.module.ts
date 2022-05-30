import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { LoginRegisterContainerComponent } from './login-register-container.component';

@NgModule({
  imports: [ CommonModule, FormsModule, IonicModule],
  declarations: [LoginRegisterContainerComponent],
  exports: [LoginRegisterContainerComponent]
})
export class LoginRegisterContainerComponentModule {}

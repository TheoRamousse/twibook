import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { InscriptionPage } from './inscription.page';
import { LoginRegisterContainerComponentModule } from '../login-register-container/login-register-container.module';

import { InscriptionPageRoutingModule } from './inscription-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    LoginRegisterContainerComponentModule,
    InscriptionPageRoutingModule,
  ],
  declarations: [InscriptionPage]
})
export class InscriptionPageModule {}

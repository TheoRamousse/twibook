import { IonicModule } from '@ionic/angular';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ConnectionPage } from './connection.page';
import { LoginRegisterContainerComponentModule } from '../login-register-container/login-register-container.module';
import { TabsPageModule } from 'src/app/tabs/tabs.module';

import { ConnectionPageRoutingModule } from './connection-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    LoginRegisterContainerComponentModule,
    ConnectionPageRoutingModule,
    TabsPageModule
  ],
  declarations: [ConnectionPage]
})
export class ConnectionPageModule { }

import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EditionProfilePage } from './edition-profile.page';
import { PostComponentModule } from '../components/post/post.module';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

import { EditionProfilePageRoutingModule } from './edition-profile-routing.module';
import { TabsPageModule } from 'src/app/tabs/tabs.module';
@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    PostComponentModule,
    RouterModule.forChild([{ path: '', component: EditionProfilePage }]),
    EditionProfilePageRoutingModule,
    TabsPageModule
  ],
  declarations: [EditionProfilePage]
})
export class EditionProfilePageModule { }

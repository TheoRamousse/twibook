import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ExemplePostPage } from './exemple-post.page';
import { PostComponentModule } from '../post/post.module';

import { ExemplePostPageRoutingModule } from './exemple-post-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    PostComponentModule,
    RouterModule.forChild([{ path: '', component: ExemplePostPage }]),
    ExemplePostPageRoutingModule,
  ],
  declarations: [ExemplePostPage],
})
export class ExemplePostPageModule { }

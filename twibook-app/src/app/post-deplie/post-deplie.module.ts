import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PostDepliePage } from './post-deplie.page';
import { PostComponentModule } from '../post/post.module';
import { CommentComponentModule } from '../comment/comment.module';

import { PostDepliePageRoutingModule } from './post-deplie-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    CommentComponentModule,
    PostComponentModule,
    RouterModule.forChild([{ path: '', component: PostDepliePage }]),
    PostDepliePageRoutingModule,
  ],
  declarations: [PostDepliePage]
})
export class PostDepliePageModule { }

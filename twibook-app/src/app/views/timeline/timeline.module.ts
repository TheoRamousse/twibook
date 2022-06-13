import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TimelinePage } from './timeline.page';
import { PostComponentModule } from '../components/post/post.module'

import { TimelinePageRoutingModule } from './timeline-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    PostComponentModule,
    RouterModule.forChild([{ path: '', component: TimelinePage }]),
    TimelinePageRoutingModule,
  ],
  declarations: [TimelinePage],
})
export class TimelinePageModule { }

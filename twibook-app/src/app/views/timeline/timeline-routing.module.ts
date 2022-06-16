import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TimelinePage } from './timeline.page';
import { WINDOW_PROVIDERS } from "../../services/window.service";
import { BrowserModule } from '@angular/platform-browser';

const routes: Routes = [
  {
    path: '',
    component: TimelinePage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [WINDOW_PROVIDERS]
})
export class TimelinePageRoutingModule { }

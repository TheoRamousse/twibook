import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExemplePostPage } from './exemple-post.page';

const routes: Routes = [
  {
    path: '',
    component: ExemplePostPage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ExemplePostPageRoutingModule { }

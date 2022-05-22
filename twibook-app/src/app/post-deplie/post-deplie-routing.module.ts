import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostDepliePage } from './post-deplie.page';

const routes: Routes = [
  {
    path: '',
    component: PostDepliePage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PostDepliePageRoutingModule { }

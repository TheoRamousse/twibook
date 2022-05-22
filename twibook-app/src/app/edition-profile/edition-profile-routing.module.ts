import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditionProfilePage } from './edition-profile.page';

const routes: Routes = [
  {
    path: '',
    component: EditionProfilePage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EditionProfilePageRoutingModule { }

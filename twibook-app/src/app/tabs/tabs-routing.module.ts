import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'connection',
        loadChildren: () => import('../connection/connection.module').then(m => m.ConnectionPageModule)
      },
      {
        path: 'inscription',
        loadChildren: () => import('../inscription/inscription.module').then(m => m.InscriptionPageModule)
      },
      {
        path: 'exemple-post',
        loadChildren: () => import('../exemple-post/exemple-post.module').then(m => m.ExemplePostPageModule)
      },
      {
        path: 'post-deplie',
        loadChildren: () => import('../post-deplie/post-deplie.module').then(m => m.PostDepliePageModule)
      },
      {
        path: 'edition-profile',
        loadChildren: () => import('../edition-profile/edition-profile.module').then(m => m.EditionProfilePageModule)
      },
      {
        path: '',
        redirectTo: '/tabs/connection',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/tabs/connection',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class TabsPageRoutingModule { }

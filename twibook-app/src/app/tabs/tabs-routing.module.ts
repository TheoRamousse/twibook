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
        loadChildren: () => import('../views/connection/connection.module').then(m => m.ConnectionPageModule)
      },
      {
        path: 'inscription',
        loadChildren: () => import('../views/inscription/inscription.module').then(m => m.InscriptionPageModule)
      },
      {
        path: 'exemple-post',
        loadChildren: () => import('../views/exemple-post/exemple-post.module').then(m => m.ExemplePostPageModule)
      },
      {
        path: 'post-deplie',
        loadChildren: () => import('../views/post-deplie/post-deplie.module').then(m => m.PostDepliePageModule)
      },
      {
        path: 'edition-profile',
        loadChildren: () => import('../views/edition-profile/edition-profile.module').then(m => m.EditionProfilePageModule)
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

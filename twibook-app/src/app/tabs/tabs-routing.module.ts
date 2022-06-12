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
        path: 'edition-profile',
        loadChildren: () => import('../views/edition-profile/edition-profile.module').then(m => m.EditionProfilePageModule)
      },
      {
        path: 'post',
        loadChildren: () => import('../views/components/post/post.module').then(m => m.PostComponentModule)
      },
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

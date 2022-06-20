import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../auth/services/auth.guard';
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
        path: 'timeline',
        loadChildren: () => import('../views/timeline/timeline.module').then(m => m.TimelinePageModule),
        canActivate: [AuthGuard]
      },
      {
        path: 'edition-profile',
        loadChildren: () => import('../views/edition-profile/edition-profile.module').then(m => m.EditionProfilePageModule)
      },
    ]
  },
  {
    path: '',
    redirectTo: '/connection',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class TabsPageRoutingModule { }

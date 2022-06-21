import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../app/auth/services/auth.guard';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./tabs/tabs.module').then(m => m.TabsPageModule)
  },
  {
    path: 'connection',
    loadChildren: () => import('./views/connection/connection.module').then(m => m.ConnectionPageModule)
  },
  {
    path: 'inscription',
    loadChildren: () => import('./views/inscription/inscription.module').then(m => m.InscriptionPageModule)
  },
  {
    path: 'edition-profile',
    loadChildren: () => import('./views/edition-profile/edition-profile.module').then(m => m.EditionProfilePageModule)
  },
  {
    path: 'timeline',
    loadChildren: () => import('./views/timeline/timeline.module').then(m => m.TimelinePageModule),
    canActivate: [AuthGuard]
  },

];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}

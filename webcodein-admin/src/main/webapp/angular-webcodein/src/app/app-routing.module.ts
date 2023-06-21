import {NgModule} from '@angular/core';
import {ExtraOptions, PreloadAllModules, RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {
    path: '',loadChildren: () => import('./modules/landing/landing.module').then(m => m.LandingModule)
  }
];

const routerOption: ExtraOptions = {
  preloadingStrategy: PreloadAllModules,
  initialNavigation: 'enabledBlocking'
}

@NgModule({
  imports: [RouterModule.forRoot(routes, routerOption)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

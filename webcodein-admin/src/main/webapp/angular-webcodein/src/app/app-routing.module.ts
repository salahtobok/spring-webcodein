import {NgModule} from '@angular/core';
import {ExtraOptions, PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {LandingComponent} from "./components/landing/landing.component";
import {UserManagementComponent} from "./components/user-management/user-management.component";

const routes: Routes = [
  {
    path: '', component : LandingComponent
  }, {
    path: 'user-management', component : UserManagementComponent
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

import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LogInComponent} from './components/log-in/log-in.component';
import {OAuthModule} from "angular-oauth2-oidc";
import {LandingModule} from "./modules/landing/landing.module";
import {UserManagementModule} from "./modules/user-management/user-management.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    OAuthModule.forRoot({
      resourceServer: {
        allowedUrls: ['http://localhost:8080/api'],
        sendAccessToken: true
      }
    }),
    LandingModule,
    UserManagementModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

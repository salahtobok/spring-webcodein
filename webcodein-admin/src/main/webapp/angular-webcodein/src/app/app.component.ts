import {Component, OnInit} from '@angular/core';
import Keycloak from "keycloak-js";
import {OAuthService} from "angular-oauth2-oidc";
import {AdminService} from "../admin.service";
import {authConfig} from "../auth.config";
import {MatDialog} from "@angular/material/dialog";
import {UserAddEditComponent} from "./components/user-add-edit/user-add-edit.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'webcodein';


  constructor(private oauthService: OAuthService,private adminService : AdminService,private _dialog : MatDialog) {
    this.configure();
  }

  keycloak = new Keycloak({
    clientId: "webcodein", url: "http://localhost:8543/",
    realm: "spring-boot",
  });

  ngOnInit(): void {
/*    console.log("============================")
    this.keycloak.init({
      onLoad: 'login-required',
      silentCheckSsoRedirectUri: window.location.origin + '/silent-check-sso.html'
    })*/
  }

  public login() {
    this.oauthService.initLoginFlow();
    // this.oauthService.initCodeFlow();
  }

  public logoff() {
    this.oauthService.logOut();
  }

  private configure() {
    this.oauthService.configure(authConfig);
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
    this.oauthService.setupAutomaticSilentRefresh();
  }



  fetchRooms(): void {
    console.log(this.keycloak.token)

    this.adminService.getRooms()
      .subscribe(rooms => console.log(rooms));
  }

  openUserAddEditForm(){
    this._dialog.open(UserAddEditComponent)
  }

}

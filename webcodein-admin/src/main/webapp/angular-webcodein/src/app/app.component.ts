import {Component, OnInit, ViewChild} from '@angular/core';
import Keycloak from "keycloak-js";
import {OAuthService} from "angular-oauth2-oidc";
import {AdminService} from "../admin.service";
import {authConfig} from "../auth.config";
import {MatDialog} from "@angular/material/dialog";
import {UserAddEditComponent} from "./components/user-add-edit/user-add-edit.component";
import {UserService} from "./services/user.service";
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {User} from "./dtos/user";
import {CoreService} from "./services/core.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'webcodein';
  displayedColumns: string[] = [
    'id',
    'firstName',
    'lastName',
    'email',
    'dob',
    'gender',
    'education',
    'company',
    'experience',
    'action'
  ];
  dataSource!: MatTableDataSource<User>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private oauthService: OAuthService, private adminService: AdminService, private _dialog: MatDialog
    , private _userService: UserService,private _coreService:CoreService) {
    this.configure();
  }

  keycloak = new Keycloak({
    clientId: "webcodein", url: "http://localhost:8543/",
    realm: "spring-boot",
  });

  ngOnInit(): void {
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






}

import {Component, OnInit, ViewChild} from '@angular/core';
import Keycloak from "keycloak-js";
import {OAuthService} from "angular-oauth2-oidc";
import {AdminService} from "../admin.service";
import {authConfig} from "../auth.config";
import {MatDialog} from "@angular/material/dialog";
import {UserAddEditComponent} from "./components/user-add-edit/user-add-edit.component";
import {UserService} from "./services/user.service";
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {User} from "./dtos/user";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
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

  constructor(private oauthService: OAuthService,private adminService : AdminService,private _dialog : MatDialog
  ,private _userService: UserService) {
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
    this.getUserList()
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


  getUserList(){
    this._userService.getUsersList().subscribe({
      next : (res) => {
        console.log(res)
        this.dataSource = new MatTableDataSource(res)
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error : console.log
    })
  }


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}

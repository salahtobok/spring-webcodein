import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {User} from "../../dtos/user";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {OAuthService} from "angular-oauth2-oidc";
import {MatDialog} from "@angular/material/dialog";
import {UserService} from "../../services/user.service";
import {CoreService} from "../../services/core.service";
import Keycloak from "keycloak-js";
import {authConfig} from "../../../auth.config";
import {UserAddEditComponent} from "../user-add-edit/user-add-edit.component";

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent implements OnInit {
  title = 'webcodein';
  displayedColumns: string[] = [
    'id',
    'firstName',
    'lastName',
    'email',
    'dob',
    'gender',
    'action'
  ];
  dataSource!: MatTableDataSource<User>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private oauthService: OAuthService,private _dialog: MatDialog
    , private _userService: UserService,private _coreService:CoreService) {
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
    if (!this.oauthService.hasValidIdToken())
      this.oauthService.initLoginFlow();

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



  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  openUserAddForm() {
    const dialogRef = this._dialog.open(UserAddEditComponent);
    dialogRef.afterClosed().subscribe({
      next : (value) => {
        if (value){
          this.getUserList();
        }
      }
    })
  }

  openUserEditForm(data : any) {
    const dialogRef = this._dialog.open(UserAddEditComponent,{data,});
    dialogRef.afterClosed().subscribe({
      next : (value) => {
        if (value){
          this.getUserList();
        }
      }
    })
  }


  getUserList() {
    this._userService.getUsersList().subscribe({
      next: (res) => {
        console.log(res)
        this.dataSource = new MatTableDataSource(res)
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: console.log
    })
  }


  deleteUser(id: number) {
    this._userService.deleteUser(id).subscribe({
      next: (res) => {
        this._coreService.openSnackBar("User deleted","Done")
        this.getUserList();
      }, error: console.log
    })
  }
}

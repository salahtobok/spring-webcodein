import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {User} from "../../dtos/user";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {OAuthService} from "angular-oauth2-oidc";
import {AdminService} from "../../../admin.service";
import {MatDialog} from "@angular/material/dialog";
import {UserService} from "../../services/user.service";
import {CoreService} from "../../services/core.service";
import Keycloak from "keycloak-js";
import {authConfig} from "../../../auth.config";
import {UserAddEditComponent} from "../user-add-edit/user-add-edit.component";

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.scss']
})
export class LandingComponent {

}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserManagementRoutingModule } from './user-management-routing.module';
import {UserManagementComponent} from "../../components/user-management/user-management.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatDividerModule} from "@angular/material/divider";
import {MatIconModule} from "@angular/material/icon";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatDialogModule} from "@angular/material/dialog";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatRadioModule} from "@angular/material/radio";
import {MatSelectModule} from "@angular/material/select";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatSortModule} from "@angular/material/sort";
import {MatTableModule} from "@angular/material/table";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {UserAddEditComponent} from "../../components/user-add-edit/user-add-edit.component";


@NgModule({
  declarations: [
    UserManagementComponent,
    UserAddEditComponent
  ],
  imports: [
    CommonModule,
    UserManagementRoutingModule,
    BrowserAnimationsModule,
    MatDividerModule,
    MatIconModule,
    MatGridListModule,
    MatButtonModule,
    MatToolbarModule, MatButtonModule, MatIconModule, MatDialogModule, MatFormFieldModule, MatInputModule, MatDatepickerModule,
    MatNativeDateModule, MatRadioModule, MatSelectModule,ReactiveFormsModule, HttpClientModule, MatPaginatorModule,MatPaginatorModule,
    MatSortModule,
    MatTableModule,
    MatInputModule,
    MatFormFieldModule,MatSnackBarModule,MatGridListModule,MatDividerModule
  ]
})
export class UserManagementModule { }

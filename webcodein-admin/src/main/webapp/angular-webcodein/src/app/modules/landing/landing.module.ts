import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {LandingRoutingModule} from './landing-routing.module';
import {LandingComponent} from "../../components/landing/landing.component";
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
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";


@NgModule({
  declarations: [
    LandingComponent,
  ],
  imports: [
    CommonModule,
    LandingRoutingModule,
    MatDividerModule,MatIconModule,MatGridListModule,MatButtonModule,MatToolbarModule, MatButtonModule, MatIconModule, MatDialogModule,
    MatFormFieldModule, MatInputModule, MatDatepickerModule, MatNativeDateModule, MatRadioModule, MatSelectModule,ReactiveFormsModule,
    HttpClientModule, MatPaginatorModule,MatPaginatorModule,MatSortModule,MatTableModule,MatInputModule, MatFormFieldModule,
    MatSnackBarModule,MatGridListModule,MatDividerModule
  ],
})
export class LandingModule { }

import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {User} from "../../dtos/user";
import {CoreService} from "../../services/core.service";

@Component({
  selector: 'app-user-add-edit',
  templateUrl: './user-add-edit.component.html',
  styleUrls: ['./user-add-edit.component.scss']
})
export class UserAddEditComponent implements OnInit {
  userForm: FormGroup;

  education: string[] = [
    'Metrics',
    'Intermediate',
    'Diploma',
    'Intermediate',
    'Graduate',
    'Post Graduate'
  ]

  constructor(private _fb: FormBuilder, private _userService: UserService, private _dialogRef: MatDialogRef<UserAddEditComponent>
    , @Inject(MAT_DIALOG_DATA) public data: User,private _coreService:CoreService) {
    this.userForm = this._fb.group({
      firstName: '',
      lastName: '',
      email: '',
      dob: '',
      gender: '',
      education: '',
      company: '',
      experience: ''

    })
  }

  ngOnInit(): void {
    this.userForm.patchValue(this.data)
  }

  onUserFormSubmit() {
    if (this.userForm.valid) {
      console.log(this.data)
      if (this.data == null) {
        this._userService.addUser(this.userForm.value).subscribe({
          next: (value: any) => {
            this._coreService.openSnackBar("User added successfully","Done")
            this._dialogRef.close(true)
          },
          error: (error: any) => {
            console.log(error)
          }
        })
      } else if (this.data) {
        console.log(this.userForm.value)
        this._userService.updateUser(this.data.id, this.userForm.value).subscribe({
          next: (value: any) => {
            this._coreService.openSnackBar("User updated successfully","Done")
            this._dialogRef.close(true)
          },
          error: (error: any) => {
            console.log(error)
          }
        })
      }
    }

  }
}

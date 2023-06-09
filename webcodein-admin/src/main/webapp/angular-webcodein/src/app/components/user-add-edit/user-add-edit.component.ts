import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {User} from "../../dtos/user";
import {CoreService} from "../../services/core.service";

@Component({
  selector: 'app-user-add-edit',
  templateUrl: './user-add-edit.component.html',
  styleUrls: ['./user-add-edit.component.scss']
})
export class UserAddEditComponent implements OnInit {
  userForm: FormGroup;

  constructor(private _fb: FormBuilder, private _userService: UserService, private _dialogRef: MatDialogRef<UserAddEditComponent>
    , @Inject(MAT_DIALOG_DATA) public data: User,private _coreService:CoreService) {
    this.userForm = this._fb.group({
      firstName: '',
      lastName: '',
      email: '',
      dob: '',
      gender: '',
    })
  }

  ngOnInit(): void {
    this.userForm.patchValue(this.data)
  }

  onUserFormSubmit() {
    if (this.userForm.valid) {
      console.log(this.data)
      if (this.data == null) {
        this._userService.createUser(this.userForm.value).subscribe({
          next: (value: any) => {
            this._coreService.openSnackBar("User added successfully","Done")
            this._dialogRef.close(true)
          },
          error: (error: any) => {
            this._coreService.openSnackBar("Error while adding the user","Done")
            console.log(error)
          }
        })
      } else if (this.data) {
        console.log(this.userForm.value);
        let user: User = this.userForm.value;
        user.uuid = this.data.uuid;
        this._userService.updateUser(user).subscribe({
          next: (value: any) => {
            this._coreService.openSnackBar("User updated successfully","Done")
            this._dialogRef.close(true)
          },
          error: (error: any) => {
            this._coreService.openSnackBar("Error while updating the user","Done")
            console.log(error)
          }
        })
      }
    }

  }
}

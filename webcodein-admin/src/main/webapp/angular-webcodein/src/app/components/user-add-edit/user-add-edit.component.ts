import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {DialogRef} from "@angular/cdk/dialog";

@Component({
  selector: 'app-user-add-edit',
  templateUrl: './user-add-edit.component.html',
  styleUrls: ['./user-add-edit.component.scss']
})
export class UserAddEditComponent {
  userAddEditForm : FormGroup;

  education : string[] = [
    'Metrics',
    'Intermediate',
    'Diploma',
    'Intermediate',
    'Graduate',
    'Post Graduate'
  ]

  constructor(private _fb: FormBuilder,private _userService:UserService,private _dialogRef : DialogRef<UserAddEditComponent>) {
    this.userAddEditForm = this._fb.group({
      firstName: '' ,
      lastName: '',
      email : '',
      dob:'',
      gender:'',
      education:'',
      company:'',
      experience:''

    })
  }

  onUserAddEditFormSubmit() {
    if (this.userAddEditForm.valid){
      this._userService.addUser(this.userAddEditForm.value).subscribe({
        next:(value : any) => {
          alert("User added successfully");
          this._dialogRef.close()
        },
        error:(error : any) => {
          console.log(error)
        }
      })
      console.log(this.userAddEditForm.value)
    }
  }
}

import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";

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

  constructor(private _fb: FormBuilder) {
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
      console.log(this.userAddEditForm.value)
    }
  }
}

import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../dtos/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly apiHostUrl = "https://localhost:8081/api/v1";


  constructor(private _http: HttpClient) {
  }

  createUser(data: User): Observable<any> {
    return this._http.post(this.apiHostUrl + "/admin/users/create", data);
  }


  updateUser(data: User): Observable<any> {
    return this._http.post(this.apiHostUrl +"/admin/users/update" , data);
  }

  getUser(id: any): Observable<any> {
    return this._http.get(this.apiHostUrl+"/admin/users",id)
  }

  deleteUser(data: User): Observable<any> {
    console.log("data => "+data)
    return this._http.post(this.apiHostUrl+"/admin/users/delete",data)
  }

  getUsersList(): Observable<any> {
    return this._http.get(this.apiHostUrl+"/admin/users")
  }
}

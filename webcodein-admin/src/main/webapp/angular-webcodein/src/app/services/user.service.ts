import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly apiHostUrl = "https://localhost:8081/api/v1";


  constructor(private _http: HttpClient) {
  }

  addUser(data: any): Observable<any> {
    return this._http.post(this.apiHostUrl + "/users", data);
  }


  updateUser(id: number ,data: any): Observable<any> {
    return this._http.put(this.apiHostUrl +`/users/${id}` , data);
  }

  getUsersList(): Observable<any> {
    return this._http.get(this.apiHostUrl+"/admin/users")
  }

  getUser(id: any): Observable<any> {
    return this._http.get(this.apiHostUrl+"/users ",id)
  }

  deleteUser(id: number): Observable<any> {
    console.log("id => "+id)
    return this._http.delete(this.apiHostUrl+`/users/${id}`)
  }
}

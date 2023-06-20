import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly apiHostUrl = "http://localhost:3000";


  constructor(private _http: HttpClient) {
  }

  addUser(data: any): Observable<any> {
    return this._http.post(this.apiHostUrl + "/users", data);
  }

  getUsersList(): Observable<any> {
    return this._http.get(this.apiHostUrl+"/users")
  }

  getUser(id: any): Observable<any> {
    return this._http.get(this.apiHostUrl+"/users ",id)
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IUser } from './interface/user';
import { CookieService } from 'ngx-cookie-service';
import { IQuestion } from './interface/question';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  _loginUrl = "http://localhost:8080/login";
  _registerUrl = "http://localhost:8080/rest/register";
  _baseUrl = "http://localhost:8080/rest/user/";

  constructor(private http: HttpClient,private cookieService:CookieService) { }

  registerUser( user:IUser){
    // let param = new HttpParams().set("username",user.username).set("password",user.password);
    return this.http.post<any>(this._registerUrl,user);
  }

  loginUser( user:IUser){
    let param = new HttpParams().set("username",user.username).set("password",user.password);
    return this.http.post<any>(this._loginUrl,param);
  }

  getUserById(id:number):Observable<IUser>{
    return this.http.get<IUser>(this._baseUrl + id)
  }

  getUserQuestions(id:number):Observable<IQuestion[]>{
    return this.http.get<IQuestion[]>(this._baseUrl + id + "/questions"); 
  }
}

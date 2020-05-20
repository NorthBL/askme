import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IAnswer } from './interface/answer';

@Injectable({
  providedIn: 'root'
})
export class AnswserService {

  private _urlAddAnswer="http://localhost:8080/rest/answer";

  constructor(private _http: HttpClient) { }


  addAnswer(answer: IAnswer){
    return this._http.post<any>(this._urlAddAnswer, answer);
  }
}

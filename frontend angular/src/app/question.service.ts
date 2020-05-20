import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IQuestion } from './interface/question';
import { IAnswer } from './interface/answer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  _urlGetQuestions="http://localhost:8080/rest/questions";
  _baseUrl =  "http://localhost:8080/rest/question/";

  constructor( private http: HttpClient) { }
 

  addQuestion( question: IQuestion){
   return this.http.post<any>(this._baseUrl,question);
  }

  getQuestionById( id:number):Observable<IQuestion>{
    return this.http.get<IQuestion>(this._baseUrl + id);
  }

  getQuestionAnswers(id: number):Observable<IAnswer[]>{
    return this.http.get<IAnswer[]>(this._baseUrl + id + "/answers");
  }
  getQuestions():Observable<IQuestion[]>{
   return this.http.get<IQuestion[]>(this._urlGetQuestions);
  }

}

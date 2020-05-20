import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ICategory } from './interface/category';
import {Observable} from 'rxjs';
import { IQuestion } from './interface/question';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private _url="http://localhost:8080/rest/categories";
  private _baseUrl="http://localhost:8080/rest/category/"

  constructor(private http: HttpClient) { }

  getCat():Observable<ICategory[]>{
    const a= this.http.get<ICategory[]>(this._url);
    console.log(a);
    return a;
  }

  getCategoryQuestions(id:number):Observable<IQuestion[]>{
      return this.http.get<IQuestion[]>(this._baseUrl + id + "/questions");
  }

  getCategoryById(id:number):Observable<ICategory>{
    return this.http.get<ICategory>(this._baseUrl + id);
  }
}

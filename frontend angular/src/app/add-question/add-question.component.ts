import { Component, OnInit } from '@angular/core';
import { ICategory } from '../interface/category';
import { IQuestion } from '../interface/question';
import { QuestionService } from '../question.service';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {

  question= new IQuestion();
  categories=[];

  constructor(private questionService: QuestionService, private _categoryService: CategoryService) 
  {
  
    this.question.category= new ICategory();
  }

  
  
  ngOnInit() {
    this._categoryService.getCat()
    .subscribe(data => this.categories=data);
  }

  onSubmit(){
   this.questionService.addQuestion(this.question)
   .subscribe(
     data => {
       console.log("Success!", data);
       location.reload();
       
    },
     error => {
       console.error("Error!", error);

    }
     
   )
  }

}

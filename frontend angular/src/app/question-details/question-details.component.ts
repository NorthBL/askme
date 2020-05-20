import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, ParamMap} from '@angular/router';
import { from } from 'rxjs';
import { FnParam } from '@angular/compiler/src/output/output_ast';
import { QuestionService } from '../question.service';
import { IQuestion } from '../interface/question';
import { IAnswer } from '../interface/answer';

@Component({
  selector: 'app-question-details',
  templateUrl: './question-details.component.html',
  styleUrls: ['./question-details.component.css']
})
export class QuestionDetailsComponent implements OnInit {

  questionId:number;
  question: IQuestion;
  // answers: Array<IAnswer>;
  constructor(private questionService: QuestionService ,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
   // this.questionId= parseInt(this.route.snapshot.paramMap.get('id')); //zimame id od question
   this.route.paramMap.subscribe((params: ParamMap)=>{
     let id=parseInt(params.get('id'));
     this.questionId=id;
     this.updateData();
   });
  
  }

  updateData(){
    this.questionService.getQuestionById(this.questionId)
    .subscribe(data => this.question=data);

   this.questionService.getQuestionAnswers(this.questionId)
      .subscribe(data => this.question.answers=data);
  }

  goPrevious(){
   let previousId=this.questionId-1;
   this.router.navigate(['question', previousId]);
    
  }

  goNext(){

    let nextId=this.questionId+1;
    this.router.navigate(['question', nextId]);
 
  }
  goToQuestionsList(){
    let selectedId=this.questionId ? this.questionId : null;
    this.router.navigate(['listquestions', {id:selectedId}]);

  }

}

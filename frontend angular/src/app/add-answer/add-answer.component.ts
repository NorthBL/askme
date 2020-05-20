import { Component, OnInit, Input } from '@angular/core';
import { IAnswer } from '../interface/answer';
import { IQuestion } from '../interface/question';
import { AnswserService } from '../answser.service';

@Component({
  selector: 'app-add-answer',
  templateUrl: './add-answer.component.html',
  styleUrls: ['./add-answer.component.css']
})
export class AddAnswerComponent implements OnInit {

  @Input() questionId: number;
  @Input() answers: Array<IAnswer>;
  answer=new IAnswer();

  constructor(private answerService:AnswserService) 
  {
    this.answer.question=new IQuestion();
   }

  ngOnInit() {
    this.answer.question.id = this.questionId;
  }

  onSubmit(){
    this.answerService.addAnswer(this.answer)
    .subscribe(
      data => {
        console.log("Success!", data);
        this.answers.push(data);
    },
      error => {
        console.error("Error!", error);
        
      }
    )
    // location.reload();
   }

}

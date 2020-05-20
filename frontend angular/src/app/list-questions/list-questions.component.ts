import { Component, OnInit, Input } from '@angular/core';
import { QuestionService } from '../question.service';
import {Router} from '@angular/router';
import { IQuestion } from '../interface/question';
import { IUser } from '../interface/user';

@Component({
  selector: 'app-list-questions',
  templateUrl: './list-questions.component.html',
  styleUrls: ['./list-questions.component.css']
})
export class ListQuestionsComponent implements OnInit {

  
  @Input() questions = [];

  constructor(private questionService: QuestionService, private router: Router) { }

  ngOnInit() {
    if(this.questions.length < 1){
    this.questionService.getQuestions()
    .subscribe(data => this.questions=data);
    }
    

  }

  onSelect(question){
       this.router.navigate(['/question',question.id]);
  }

  onSelectUser(user:IUser){
    this.router.navigate(['/user',user.id]);
  }

}

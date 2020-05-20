import { Component, OnInit, Input } from '@angular/core';
import { IAnswer } from '../interface/answer';

@Component({
  selector: 'app-list-answers',
  templateUrl: './list-answers.component.html',
  styleUrls: ['./list-answers.component.css']
})
export class ListAnswersComponent implements OnInit {
  @Input() answers: Array<IAnswer>;

  constructor() { }

  ngOnInit() {
  }

}

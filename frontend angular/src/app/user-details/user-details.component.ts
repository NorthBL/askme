import { Component, OnInit } from '@angular/core';
import { IUser } from '../interface/user';
import { UserService } from '../user.service';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { IQuestion } from '../interface/question';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  userId: number;
  user: IUser;
  questions: Array<IQuestion>;

  constructor(private userService:UserService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap)=>{
      let id=parseInt(params.get('id'));
      this.userId=id;
      this.updateData();
    });

  }

  updateData(){
    this.userService.getUserQuestions(this.userId)
    .subscribe(
      (data) => {this.questions = data},
      (error) => {console.error("error")}
    )

    this.userService.getUserById(this.userId)
    .subscribe(
      (data) => {this.user = data},
      (error) => {console.error("error")}
    )
  }

}

import { Component, OnInit } from '@angular/core';
import { IUser } from '../interface/user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 user= new IUser();

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  onSubmit(){
    this.userService.loginUser(this.user)
    .subscribe(
      (data) => {console.log(data)},
      (error) => {console.log(error)}
      )
  }

}

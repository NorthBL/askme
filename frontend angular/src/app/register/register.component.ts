import { Component, OnInit } from '@angular/core';
import { IUser } from '../interface/user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user = new IUser();

  constructor(private userService: UserService) {
  }

  ngOnInit() {
  }

  onSubmit(){
    this.userService.registerUser(this.user)
    .subscribe(
      (data) => {console.log(data)},
      (error) => {console.log(error)}
      )
  }
}

/**
 * Created by japnica on 8/7/2017.
 */
import {Component} from "@angular/core";
import {Router} from "@angular/router";
import {Register} from "../register/register.model";
import {Login} from "./login.service";
@Component({
  selector: 'login-root',
  templateUrl: './login.component.html'
})
export class LoginDialogComponent {
  user: Register;

  constructor(private login : Login,
  private router : Router){
    this.user = new Register();
  }

  save(){
    this.login.create(btoa(this.user.userName+":"+this.user.password));
    console.log("login successful");
    this.router.navigate(['display-student']);
  }

  register(){
    this.router.navigate(['register']);
  }
}

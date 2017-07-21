/**
 * Created by japnica on 7/21/2017.
 */
import {Component} from "@angular/core";
import {Register} from "./register.model";
import {RegisterService} from "./register.service";
@Component({
  selector : 'register',
  templateUrl : './register.component.html'
})
export class RegisterComponent {
  register : Register;
  confirmPassword : string;
  doNotMatch : string;
  success : boolean;

  constructor(
    private registerService : RegisterService
  ){
    this.register = new Register();
    this.success = false;
  }

  save(){

      if(this.register.password != this.confirmPassword){
        this.doNotMatch = 'ERROR';
      }else{
        this.doNotMatch = null;
        this.registerService.save(this.register).subscribe(
          () => {this.success = true;},
          () => console.log("error")
        );
      }
  }
}

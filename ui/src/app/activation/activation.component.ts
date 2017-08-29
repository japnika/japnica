/**
 * Created by japnica on 8/29/2017.
 */
import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {ActivationService} from "./activation.service";
@Component({
  selector : 'activation',
  templateUrl : './activation.component.html'
})
export class ActivationComponent implements OnInit{
  activationKey : string;

  constructor(
    private route : ActivatedRoute,
    private activationService : ActivationService,
    private router : Router
  ){

  }

  ngOnInit(){
    this.route
      .queryParams
      .subscribe(params => {
        this.activationKey = params['key'];
      });
    this.activationService.activateUser(this.activationKey).subscribe(response => console.log('success'), () => console.log('error'));
  }

  login(){
    this.router.navigate(['login']);
  }
}

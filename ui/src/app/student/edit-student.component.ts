/**
 * Created by japnica on 7/20/2017.
 */
import {Component, OnDestroy, OnInit} from "@angular/core";
import {Student} from "./student.model";
import {StudentService} from "./student.service";
import {ActivatedRoute, Router} from "@angular/router";
@Component({
  selector: 'student-edit',
  templateUrl: './student.component.html'
})

export class EditStudentComponent implements OnInit, OnDestroy{
  student : Student;
  private subscription: any;

  constructor(
    private studentService: StudentService,
    private route: ActivatedRoute,
    private router: Router
  ){
    this.student = new Student();
  }

  ngOnInit(){
    this.subscription = this.route.params.subscribe(params => {
      this.load(params['id']);
    });
  }

  load(id){
    this.studentService.find(id).subscribe(response => this.onSuccessGet(response), () => console.log("error"));
  }

  onSuccessGet(res){
    this.student = res.json();
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

  save(){
      this.studentService.update(this.student).subscribe(response => this.onSuccess(response), () => this.onError());
  }

  onSuccess(result) {
    console.log("success");
    this.router.navigate(['display-student']);
  }

  onError(){
    console.log("error");
  }
}

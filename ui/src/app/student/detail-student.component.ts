/**
 * Created by japnica on 7/20/2017.
 */
import {Component, OnDestroy, OnInit} from "@angular/core";
import {Student} from "./student.model";
import {StudentService} from "./student.service";
import {ActivatedRoute} from "@angular/router";
@Component({
  selector: 'student-detail',
  templateUrl: './detail-student.component.html'
})
export class StudentDetailComponent implements OnInit, OnDestroy{
  student : Student;
  private subscription: any;

  constructor(
    private studentService : StudentService,
    private route: ActivatedRoute
  ){
    this.student = new Student();
  }

  ngOnInit(){
      this.subscription = this.route.params.subscribe(params => {
        this.load(params['id']);
      });
  }

  load(id){
    this.studentService.find(id).subscribe(response => this.onSuccess(response), () => console.log("error"));
  }

  onSuccess(res){
    this.student = res.json();
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}

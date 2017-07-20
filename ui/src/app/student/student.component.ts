/**
 * Created by japnica on 6/23/2017.
 */
import {Component} from '@angular/core';
import {Student} from "./student.model";
import {StudentService} from "./student.service";
import {Router} from "@angular/router";
@Component({
  selector : 'student-post',
  templateUrl: './student.component.html'
})
export class StudentComponent {
  student: Student;
  constructor(
    private studentService: StudentService,
    private router: Router
  ) {
    this.student= new Student();
  }
  save(){
    this.studentService.save(this.student).subscribe(response => this.onSaveSuccess(response), () => this.onSaveError());
  }

  private onSaveSuccess(result){
    this.router.navigate(['display-student']);
  }

  private onSaveError(){
    console.log("error");
  }
}

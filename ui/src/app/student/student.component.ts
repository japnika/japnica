/**
 * Created by japnica on 6/23/2017.
 */
import {Component} from '@angular/core';
import {Student} from "./student.model";
import {StudentService} from "./student.service";
@Component({
  selector : 'student-post',
  templateUrl: './student.component.html'
})
export class StudentComponent {
  student: Student;
  constructor(
    private studentService: StudentService
  ) {
    this.student= new Student();
  }
  save(){
    console.log(this.student);
    this.studentService.save(this.student).subscribe(response => this.onSaveSuccess(response), () => this.onSaveError());
  }

  private onSaveSuccess(result){
    console.log("success");
  }

  private onSaveError(){
    console.log("error");
  }
}

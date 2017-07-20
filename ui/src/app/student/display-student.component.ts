/**
 * Created by japnica on 6/27/2017.
 */
import {Component, OnInit} from "@angular/core";
import {Student} from "./student.model";
import {StudentService} from "./student.service";
import {Response} from "@angular/http";
@Component({
  selector: 'display-student',
  templateUrl: './display-student.component.html'
})
export class DisplayStudentComponent implements OnInit{
  students: Student;

  constructor(
    private studentService: StudentService
  ){

  }

  ngOnInit(){
      this.loadAll();
  }

  loadAll(){
    this.studentService.query().subscribe(
      (res: Response) => this.onSuccess(res.json()),
      (res: Response) => this.onError(res.json())
    );
  }

  private onSuccess(data){
    console.log("success display student info");
    this.students = data;
    console.log(this.students);
  }

  private onError(error){
    console.log("error display student info");
  }

  delete(id) {
    this.studentService.delete(id).subscribe(res => this.onSuccessDel(), () => console.log("error while deleting"));
  }

  onSuccessDel(){
    this.studentService.query().subscribe(response => this.onSuccess(response.json()), () => console.log('error'));
  }
}

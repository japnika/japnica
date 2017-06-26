/**
 * Created by japnica on 6/26/2017.
 */
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Student} from "./student.model";
@Injectable()
export class StudentService{
  private resourceUrl= 'http://localhost:9000/api/student';

  constructor(private http: Http){

  }

  save(student: Student){
    return this.http.post(this.resourceUrl, student);
  }
}

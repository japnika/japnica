/**
 * Created by japnica on 6/26/2017.
 */
import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Student} from "./student.model";
import {Observable} from "rxjs";
@Injectable()
export class StudentService{
  private resourceUrl= 'http://localhost:9000/api/student';

  constructor(private http: Http){

  }

  save(student: Student){
    return this.http.post(this.resourceUrl, student);
  }

  query(){
    return this.http.get(this.resourceUrl);
  }

  find(id: number){
    return this.http.get(`${this.resourceUrl}/${id}`);
  }

  update(student: Student){
    return this.http.put(this.resourceUrl, student);
  }

  delete(id: number){
    return this.http.delete(`${this.resourceUrl}/${id}`);
  }
}

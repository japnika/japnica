/**
 * Created by japnica on 7/21/2017.
 */
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Register} from "./register.model";
@Injectable()
export class RegisterService {
  private resourceUrl = 'http://localhost:9000/api/register';

  constructor(private http : Http){

  }

  save(register : Register){
    return this.http.post(this.resourceUrl, register);
  }
}

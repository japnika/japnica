/**
 * Created by japnica on 8/13/2017.
 */
import {Injectable, OnInit} from "@angular/core";
import {Headers, Http, RequestOptions} from "@angular/http";
@Injectable()
export class Login implements OnInit {
  private resourceUrl = "http://localhost:9000/api/login";
  private headers : Headers;

  constructor(private http : Http) {
    this.headers = new Headers();
  }

  ngOnInit(){

  }

  create(token : string) {
    this.headers = new Headers();
    this.headers.append("Authorization", "Basic" + token);
    this.authentication(token);
    let options = new RequestOptions({headers : this.headers});
    return this.http.post(this.resourceUrl, "body part", options).subscribe(
      data => {
        console.log(data);
        localStorage.setItem('token', token);
      },
      err => {
        console.log(err);
        localStorage.removeItem('token');
      }
    );
  }

  authentication(token : string) {
    this.headers = new Headers();
    this.headers.append("Authorization", "Basic "+ token);
  }
}

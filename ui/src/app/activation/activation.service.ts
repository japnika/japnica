/**
 * Created by japnica on 8/29/2017.
 */
import {Injectable} from "@angular/core";
import {Http, RequestOptions, URLSearchParams } from "@angular/http";
@Injectable()
export class ActivationService {
  private resourceUrl = 'http://localhost:9000/api/users';
  constructor(private http: Http
  ){}

  activateUser(activationKey : string){
    let params: URLSearchParams = new URLSearchParams();
    params.set('key', activationKey);

    let requestOptions = new RequestOptions();
    requestOptions.search = params;

    return this.http.get(this.resourceUrl, requestOptions);
  }
}

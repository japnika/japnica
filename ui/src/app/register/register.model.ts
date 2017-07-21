/**
 * Created by japnica on 7/21/2017.
 */
export class Register {
  public id?: number;
  public userName ?: string;
  public password ?: string;

  constructor(
    id ?: number,
    userName ?: string,
    password ?: string
  ){
    this.id = id ? id : null;
    this.userName = userName ? userName : null;
    this.password = password ? password : null;
  }
}

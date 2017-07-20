/**
 * Created by japnica on 6/20/2017.
 */
export class Student {
  public id ?: number;
  public firstName ?: string;
  public middleName ?: string;
  public lastName ?: string;
  public age ?: number;
  public gender ?: string;
  public email ?: string;
  public phone ?: string;

  constructor(
    id ?: number,
    firstName ?: string,
    middleName ?: string,
    lastName ?: string,
    age ?: number,
    gender ?: string,
    email ?: string,
    phone ?: string
  ){
    this.id = id ? id : null;
    this.firstName = firstName ? firstName : null;
    this.middleName = middleName ? middleName : null;
    this.lastName = lastName ? lastName : null;
    this.age = age ? age : null;
    this.gender = gender ? gender : null;
    this.email = email ? email : null;
    this.phone = phone ? phone : null;
  }
}

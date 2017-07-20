/**
 * Created by japnica on 6/27/2017.
 */
import {Component, Injectable} from "@angular/core";
import {NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {Router} from "@angular/router";
import {StudentService} from "./student.service";
import {Student} from "./student.model";
@Injectable()
export class StudentModalService{
  private isOpen = false;
  constructor(
    private modalService: NgbModal,
    private router: Router,
    private studentService: StudentService
  ){}

  open(component: Component, id?:number): NgbModalRef{
      if(this.isOpen){
        return;
      }
      this.isOpen = true;

      if(id){
        this.studentService.find(id).subscribe(student => this.studentModalRef(component, student));
      }else{
        return this.studentModalRef(component, new Student());
      }
  }

  studentModalRef(component: Component, student: Student): NgbModalRef{
      let modalRef = this.modalService.open(component, {size: 'lg', backdrop: 'static'});
      modalRef.componentInstance.student = student;
      modalRef.result.then(result => {
        this.router.navigate([{outlets: {popup:null}}], {replaceUrl : true});
        this.isOpen = false;
      }, (reason) => {
        this.router.navigate([{outlets: {popup: null}}], {replaceUrl: true});
        this.isOpen = false;
      });
      return modalRef;
  }
}

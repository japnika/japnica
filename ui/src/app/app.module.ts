import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {StudentComponent} from "./student/student.component";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {routing} from "./app.routing";
import {StudentService} from "./student/student.service";
import {HttpModule} from "@angular/http";
import {DisplayStudentComponent} from "./student/display-student.component";
import {StudentModalService} from "./student/student-modal.service";
import {StudentDetailComponent} from "./student/detail-student.component";
import {EditStudentComponent} from "./student/edit-student.component";

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    DisplayStudentComponent,
    StudentDetailComponent,
    EditStudentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    routing,
    HttpModule
  ],
  providers: [
    StudentService,
    StudentModalService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

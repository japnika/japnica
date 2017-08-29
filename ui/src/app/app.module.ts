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
import {StudentDetailComponent} from "./student/detail-student.component";
import {EditStudentComponent} from "./student/edit-student.component";
import {RegisterComponent} from "./register/register.component";
import {RegisterService} from "./register/register.service";
import {LoginDialogComponent} from "./login/login.component";
import {Login} from "./login/login.service";
import {ActivationComponent} from "./activation/activation.component";
import {ActivationService} from "./activation/activation.service";

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    DisplayStudentComponent,
    StudentDetailComponent,
    EditStudentComponent,
    RegisterComponent,
    LoginDialogComponent,
    ActivationComponent
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
    RegisterService,
    Login,
    ActivationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

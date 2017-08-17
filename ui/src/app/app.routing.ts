import {RouterModule, Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {StudentComponent} from "./student/student.component";
import {ModuleWithProviders} from "@angular/core";
import {DisplayStudentComponent} from "./student/display-student.component";
import {StudentDetailComponent} from "./student/detail-student.component";
import {EditStudentComponent} from "./student/edit-student.component";
import {RegisterComponent} from "./register/register.component";
import {LoginDialogComponent} from "./login/login.component";
/**
 * Created by japnica on 6/23/2017.
 */
export const testRoute : Routes = [
  {
    path: '',
    component: AppComponent
  },
  {
    path: 'student',
    component: StudentComponent
  },
  {
    path: 'display-student',
    component: DisplayStudentComponent
  },
  {
    path: 'student/:id',
    component: StudentDetailComponent
  },
  {
    path : 'student/edit/:id',
    component: EditStudentComponent
  },
  {
    path : 'register',
    component: RegisterComponent
  },
  {
    path : 'login',
    component : LoginDialogComponent
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(testRoute);


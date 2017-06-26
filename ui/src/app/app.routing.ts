import {RouterModule, Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {StudentComponent} from "./student/student.component";
import {ModuleWithProviders} from "@angular/core";
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
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(testRoute);


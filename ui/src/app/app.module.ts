import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {StudentComponent} from "./student/student.component";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {routing} from "./app.routing";
import {StudentService} from "./student/student.service";
import {HttpModule} from "@angular/http";

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    routing,
    HttpModule
  ],
  providers: [
    StudentService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

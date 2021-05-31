import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";
import {RouterModule} from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BugformComponent } from './bugform/bugform.component';
import BugService from './services/BugService';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    BugformComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, HttpClientModule,ReactiveFormsModule,RouterModule
  ],
  providers: [BugService],
  bootstrap: [AppComponent]
})
export class AppModule { }

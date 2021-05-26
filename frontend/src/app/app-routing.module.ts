import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BugformComponent } from './bugform/bugform.component';

const routes: Routes = [
  { path: 'bugform', component: BugformComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

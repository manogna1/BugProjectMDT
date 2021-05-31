import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
username : string ='';
password : string = '';
message : any ='';
  constructor(private auth : AuthServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    this.auth.login(this.username, this.password).subscribe(res =>{
      this.message = res;
      this.router.navigateByUrl('/home');
    })
  }
}

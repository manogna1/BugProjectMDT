import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http:HttpClient) { }

  login(user : string, pwd : string){
    const headers = new HttpHeaders({
      Authorization : 'Basic ' + btoa(user+':'+pwd),
      // 'Access-Control-Allow-Origin' : "*",
      // 'Access-Control-Allow-Methods' : 'GET, POST, PATCH, PUT, DELETE, OPTIONS'
      'Access-Control-Allow-Origin': '*',
     'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
    })

  return this.http.get("http://localhost:8085/bug",{headers, responseType : 'text' as 'json'})
  }
}

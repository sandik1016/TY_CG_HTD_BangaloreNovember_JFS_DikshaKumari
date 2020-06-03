import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  
  url = 'http://localhost:8080';
 
  userName: any;
  dateOfBirth: any;
  contact: any;
  theaterCity: string;
  theater: any;
  theaterName:string;
  constructor(private http: HttpClient) { }

  loginUser(userCredentials): Observable<any> {
    return this.http.post<any>(`${this.url}/userLogin`, userCredentials);
  }
  addUserData(user): Observable<any> {
    return this.http.post<any>(`${this.url}/userRegister`, user);
  }
  forgotPassword(user): Observable<any> {
    return this.http.put<any>(`${this.url}/change-password`,user);
   }
   updateContact(user): Observable<any> {
    return this.http.put<any>(`${this.url}/update-contact`,user);
   }
   getTheater(search):Observable<any>{
     return this.http.get<any>(`${this.url}/search-theater/${search}`);
   }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  URL = 'http://localhost:8080/user/';

  constructor(private http: HttpClient) { }

  public getUser(): Observable<User>{
    return this.http.get<User>(this.URL+'get/perfil');
  }
}

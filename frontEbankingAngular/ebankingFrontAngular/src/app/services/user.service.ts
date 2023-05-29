import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {UserAuthService} from "./user-auth.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });
  constructor(
    private httpclient: HttpClient,
    private userAuthService: UserAuthService
  ) {}

  public login(loginData: any) {
    return this.httpclient.post(environment.backendHost + '/authenticate', loginData, {
      headers: this.requestHeader,
    });
  }

  public forUser() {
    return this.httpclient.get(environment.backendHost + '/forUser', {
      responseType: 'text',
    });
  }


  public forAdmin() {
    return this.httpclient.get(environment.backendHost + '/forAdmin', {
      responseType: 'text',
    });
  }

  // @ts-ignore
  public roleMatch(allowedRoles): boolean {
    let isMatch = false;
    const userRoles: any = this.userAuthService.getRoles();

    if (userRoles != null && userRoles) {
      for (let i = 0; i < userRoles.length; i++) {
        for (let j = 0; j < allowedRoles.length; j++) {
          if (userRoles[i].roleName === allowedRoles[j]) {
            isMatch = true;
            return isMatch;
          } else {
            return isMatch;
          }
        }
      }
    }
  }
}

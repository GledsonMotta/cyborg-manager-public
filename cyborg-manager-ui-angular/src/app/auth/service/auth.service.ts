import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppGlobals } from '../../app.globals';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private endpoint = this.appGlobals.cybmgrapi_endpoint_url;
 
  constructor(private http: HttpClient, private appGlobals: AppGlobals) { }


  /** To be Implemented*/
  getUserName(){    
    return "Gledson Santos";
  }

  getUserInitials(){
    return "GS"
  }

}

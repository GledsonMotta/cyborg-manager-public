import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppGlobals } from '../../app.globals';

//import { AppGlobals } from '/app/app.globals';

@Injectable({
  providedIn: 'root'
})
export class RobotService {

  private endpoint = this.appGlobals.cybmgrapi_endpoint_url;
  public robotPath = this.endpoint+'/robot';
  public rbInstancePath = this.endpoint+'/rbinstance';
  public robot: any = { list:[] };
  public rbInstance: any = { list:[] };

  constructor(private http: HttpClient, private appGlobals: AppGlobals) { }

  listAll(){    
    this.robot.loading = true;
    return this.http.get<any[]>(this.robotPath);
  }

  listAllRbInstances(){
    this.rbInstance.loading = true;
    return this.http.get<any[]>(this.rbInstancePath);
  }

  addNew(robot){
    return this.http.post(this.robotPath, robot)
  }

}

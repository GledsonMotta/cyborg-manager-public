import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppGlobals } from '../../app.globals';

@Injectable({
  providedIn: 'root'
})
export class AttributeService {

  private endpoint = this.appGlobals.cybmgrapi_endpoint_url;
  public attributePath = this.endpoint+'/attributes';
  public attributeTypePath = this.endpoint+'/attribute-types';

  constructor(private http: HttpClient, private appGlobals: AppGlobals) { }

  listAll(){    
    return this.http.get<any[]>(this.attributePath);
  }

  listType(){
    return this.http.get<any[]>(this.attributeTypePath);
  }

  addNew(attribute){
    return this.http.post(this.attributePath, attribute)
  }

  delete(attribute){
    return this.http.delete(this.attributePath+"/"+attribute.id);
  }
}

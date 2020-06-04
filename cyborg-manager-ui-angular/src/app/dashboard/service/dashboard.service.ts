import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  
  public Dashboard: any = { list:[] };
  public robot: any = { list:[] };
  public rbInstance: any = { list:[] };
  public attribute: any = { list:[] };
  public attributeType: any = { list:[] };

  constructor() {}

  /**
   * author Haeralis
   * 
   * objToSet: Object where to set some generic value
   * arrValues: Array of Objects where the values will be retrieved
   * arrGetKeyValues: Array of strings representing the cascading of properties in the object,
   *                  each string represents a property ou a path to a property separated by dot.
   *                  e.g. for "object.property1.property2" function should receive ['property1.property2']
   * arrSetKeyValue: Array of strings representing the property name where to set the respective value in the 
   *                  objToSet for each of arrGetKeyValues
   */
  public genericGetAndSetLoop(objToSet: any, arrValues: any[], arrGetKeyValues: any[], arrSetKeyValue: any[]){
    let value: any;
    let arrGetKeySplit: any[];

    arrSetKeyValue.forEach(setKeys => {
      objToSet[setKeys] = [];
    });

    //Test if getkeyvalues and setkeyvalues have same length 
    if(arrGetKeyValues.length!=arrSetKeyValue.length){
      return; 
    }
    //Loop in the Values(Objects) array
    arrValues.forEach(valuesObj => {
      
      //Loop in the strings that represent the path to variable
      arrGetKeyValues.forEach( (keysStr, index) => {
        value = valuesObj; 
        arrGetKeySplit = keysStr.split(".");
        //loop in the splited path to variable
        arrGetKeySplit.forEach( keysStr => {
          //loop and set the value until find the end of path
          value = value[keysStr]; 
        });
        //after get the final value, set it to destination based on SetKeyValue
        objToSet[arrSetKeyValue[index]].push(value);
      });      
            
    });

    console.log(objToSet);
  }  
}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppUtilsModule } from '../app-utils.module';
import { FlexLayoutModule } from '@angular/flex-layout';

import { RobotRoutingModule } from './robot-routing.module';

import { RobotComponent } from './robot.component';
import { RobotModelComponent } from './model/robot-model.component';



@NgModule({  
  imports: [
    CommonModule,
    AppUtilsModule,
    RobotRoutingModule,
    FlexLayoutModule
  ],
  declarations: [
    RobotComponent,
    RobotModelComponent
  ],
})
export class RobotModule { }

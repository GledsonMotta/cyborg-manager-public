import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RobotComponent } from './robot.component';
import { RobotModelComponent } from './model/robot-model.component';

const routes: Routes = [
  { 
    path: 'robot',
    data: {
      breadcrumb: 'Robot'
    } ,
    children: [ 
      { 
        data: {
          breadcrumb: null
        },
        path: '', 
        component: RobotComponent 
      },
      { 
        data: {
          breadcrumb: 'Robot Models'
        },
        path: 'robot-model', 
        component: RobotModelComponent 
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RobotRoutingModule { }

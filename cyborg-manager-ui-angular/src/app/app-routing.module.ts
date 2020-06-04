import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { RobotComponent } from './robot/robot.component';
import { RobotModelComponent } from './robot/model/robot-model.component';

const routes: Routes = [
  { 
    path: '', 
    children: [ 
      { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
      { 
        data: {
          breadcrumb: 'Dashboard'
        },
        path: 'dashboard', 
        component: DashboardComponent 
      }
    ]
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

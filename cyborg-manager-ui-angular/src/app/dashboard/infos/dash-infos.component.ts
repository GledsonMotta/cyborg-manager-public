import { Component } from '@angular/core';
import {DashboardService} from '../service/dashboard.service';

@Component({
  selector: 'dash-infos',
  templateUrl: './dash-infos.component.html',
  styleUrls: []
})
export class DashInfosComponent {

  public dashService: DashboardService;

  constructor(private dashboardService: DashboardService) {
      this.dashService = dashboardService;
   }
    
}

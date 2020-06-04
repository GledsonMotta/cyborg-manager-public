import { Component } from '@angular/core';
import {DashboardService} from '../service/dashboard.service';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';

@Component({
  selector: 'dash-content',
  templateUrl: './dash-content.component.html',
  styleUrls: []
})
export class DashContentComponent {
  public dashService: DashboardService;

  public config: PerfectScrollbarConfigInterface = {};

  constructor(private dashboardService: DashboardService) {
      this.dashService = dashboardService;
   }
}

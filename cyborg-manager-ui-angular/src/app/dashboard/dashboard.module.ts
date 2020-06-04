import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AppUtilsModule } from '../app-utils.module';
import { NgApexchartsModule } from 'ng-apexcharts';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { PerfectScrollbarModule} from 'ngx-perfect-scrollbar';

import { DashboardRoutes } from './dashboard.routing';

import { DashboardComponent } from './dashboard.component';
import { DashChartsComponent } from './charts/dash-charts.component';
import { DashInfosComponent } from './infos/dash-infos.component';
import { DashContentComponent } from './content/dash-content.component';
import { HaeralisChartComponent } from '../shared/layout/chart/haeralis-chart.component';

@NgModule({
  imports: [
    CommonModule,
    AppUtilsModule,
    FlexLayoutModule,
    NgApexchartsModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    PerfectScrollbarModule,
    RouterModule.forChild(DashboardRoutes)
  ],
  declarations: [
    DashboardComponent,
    DashChartsComponent,
    DashInfosComponent,
    DashContentComponent,
    HaeralisChartComponent
  ]
})
export class DashboardModule {}

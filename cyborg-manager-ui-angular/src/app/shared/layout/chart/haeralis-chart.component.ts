import { Component, AfterViewInit, Input } from '@angular/core';
import { ChartOptions } from './haeralis-chart.interface';


@Component({
  selector: 'haeralis-chart',
  templateUrl: './haeralis-chart.component.html',
  styleUrls: []
})
export class HaeralisChartComponent {
  @Input() chartOptions: ChartOptions;
}

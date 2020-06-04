import {
	ApexAxisChartSeries,
	ApexChart,
	ChartComponent,
	ApexDataLabels,
	ApexPlotOptions,
	ApexResponsive,
	ApexYAxis,
	ApexLegend,
	ApexStroke,
	ApexXAxis,
	ApexFill,
	ApexTooltip
  } from "ng-apexcharts";
import {
	IBarChartOptions,
	IChartistAnimationOptions,
	IChartistData
    } from 'chartist';
    
import { ChartType, ChartEvent } from 'ng-chartist'; 

export interface Chart {
	type: ChartType;
	data: Chartist.IChartistData;
	options?: any;
	responsiveOptions?: any;
	events?: ChartEvent;
}
  
  export interface ChartOptions {
	series: any;
	chart: ApexChart;
	dataLabels?: ApexDataLabels;
	labels?: any;
	plotOptions?: ApexPlotOptions;
	yaxis?: ApexYAxis;
	xaxis?: ApexXAxis;
	fill?: ApexFill;
	tooltip?: ApexTooltip;
	stroke?: ApexStroke;
	legend?: ApexLegend;
	responsive?:ApexResponsive[];
  };
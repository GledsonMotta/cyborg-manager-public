import { Component, AfterViewInit } from '@angular/core';
import {AttributeService} from '../../attribute/service/attribute.service';
import {RobotService} from '../../robot/service/robot.service';
import {DashboardService} from '../service/dashboard.service';
import {Chart} from '../../shared/layout/chart/haeralis-chart.interface';
import {ChartOptions} from '../../shared/layout/chart/haeralis-chart.interface';

 import {
	IBarChartOptions,
	IChartistAnimationOptions,
	IChartistData
	} from 'chartist';

import { ChartType, ChartEvent } from 'ng-chartist'; 
declare var require: any;

const data: any = [];



@Component({
  selector: 'dash-charts',
  templateUrl: './dash-charts.component.html',
  styleUrls: []
})
export class DashChartsComponent  implements AfterViewInit {
	
	public attributes = [];
	public attributeTypes = [];
	public robots = [];
	public rbInstances = [];
	
	constructor(private attributeService: AttributeService, private robotService: RobotService, private dashboardService: DashboardService) {
		//this.chartOptions.series = [];
	 }

	ngAfterViewInit() {}
	ngOnInit() {this.consult();}

	consult(){
		this.dashboardService.attribute.loading=true;
		this.attributeService.listAll().subscribe(retorno => {
			this.dashboardService.attribute.list = retorno;
			this.dashboardService.attribute.loading=false;
		  //console.log(retorno);
		})  
	
		this.dashboardService.attributeType.loading=true;
		this.attributeService.listType().subscribe(retorno => {
			this.dashboardService.attributeType.list = retorno;
			this.dashboardService.attributeType.loading=false;
			this.dashboardService.genericGetAndSetLoop(
				this.dashboardService.attributeType,	
				this.dashboardService.attributeType.list,			
				['name','id'],['labels','data']				
			);
			this.chartOptionsPie.labels = this.dashboardService.attributeType.labels;
			this.chartOptionsPie.series = this.dashboardService.attributeType.data;
		}) 
		
		this.dashboardService.robot.loading = true;
		this.robotService.listAll().subscribe(retorno => {			
			this.dashboardService.robot.list = retorno;
			this.dashboardService.robot.loading = false;
		  //console.log(retorno);
		})

		this.dashboardService.rbInstance.loading = true;
		this.robotService.listAllRbInstances().subscribe(retorno => {			
			this.dashboardService.rbInstance.list = retorno;
			this.dashboardService.rbInstance.loading = false;
		})
	}
	
	chartOptionsPie: ChartOptions = {
		series: [],
		labels: [],
		chart: {
			//width: 380,
			type: "donut"
		},
		plotOptions: {
			pie: {
				donut: {
					labels: {
						show: true,
						total: {
							showAlways: true,
							show: true
						}
					}
				}
			}
		},
		dataLabels: {
			enabled: false
		},
		fill: {
			type: "gradient"
		},
		legend: {
			formatter: function(val, opts) {
				return val + " - " + opts.w.globals.series[opts.seriesIndex];
			}
		},
		responsive: [
			{
				breakpoint: 480,
				options: {
					chart: {
						width: 200
					},
					legend: {
						position: "bottom"
					}
				}
			}
		]
	};

	chartOptions: ChartOptions = {
		series: [
			{
				name: "Cyborg",
				data: [44, 55, 57, 56, 61, 58, 63, 60, 66]
			},
			{
				name: "Pure Robot",
				data: [76, 85, 101, 98, 87, 105, 91, 114, 94]
			},
			{
				name: "Defender",
				data: [35, 41, 36, 26, 45, 48, 52, 53, 41]
			}
		],
		chart: {
			type: "bar",
			height: 350
		},
		plotOptions: {
			bar: {
				horizontal: false,
				columnWidth: "55%",
				endingShape: "rounded"
			}
		},
		dataLabels: {
			enabled: false
		},
		stroke: {
			show: true,
			width: 2,
			colors: ["transparent"]
		},
		xaxis: {
			title: {
				text: "Months"
			},
			categories: [
				"Feb",
				"Mar",
				"Apr",
				"May",
				"Jun",
				"Jul",
				"Aug",
				"Sep",
				"Oct"
			]
		},
		yaxis: {
			title: {
				text: "Destructions"
			}
		},
		fill: {
			opacity: 1
		},
		tooltip: {
			y: {
				formatter: function(val) {
					return "$ " + val + " thousands";
				}
			}
		}
	};
    
}

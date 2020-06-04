import { BrowserModule } from '@angular/platform-browser';
import { MatSliderModule } from '@angular/material/slider';
import { AppUtilsModule } from './app-utils.module';
import { AvatarModule } from 'ngx-avatar';
import { FixedModule } from './fixed/fixed.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { HttpClientModule } from '@angular/common/http';
import { FlexLayoutModule } from '@angular/flex-layout';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PerfectScrollbarModule, PerfectScrollbarConfigInterface,
  PERFECT_SCROLLBAR_CONFIG } from 'ngx-perfect-scrollbar';

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { RobotModule } from './robot/robot.module';
import { AppRoutingModule } from './app-routing.module';

import { environment } from '../environments/environment';
import { AuthService } from './auth/service/auth.service';
import { AttributeService } from './attribute/service/attribute.service';
import { RobotService } from './robot/service/robot.service';

import { AppComponent } from './app.component';
import { AppGlobals } from './app.globals';
import { AppContentContainerComponent } from './fixed/content/content-container.component';
import { AppSidebarComponent } from './fixed/sidebar/sidebar.component';
import { AppHeaderComponent } from './fixed/header/header.component';
import { SpinnerComponent } from './shared/layout/spinner.component';
import { BreadcrumbComponent } from './fixed/breadcrumb/breadcrumb.component';


const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  wheelPropagation: true
};



@NgModule({
  declarations: [
    AppComponent,
    AppContentContainerComponent,
    AppSidebarComponent,
    AppHeaderComponent,
    SpinnerComponent,
    BreadcrumbComponent
  ],
  imports: [
    BrowserModule,
    MatSliderModule,
    RobotModule,
    AppRoutingModule,
    AppUtilsModule,
    AvatarModule,
    FixedModule,
    DashboardModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    PerfectScrollbarModule,
    RouterModule,
    HttpClientModule    
  ],
  providers: [
    {
      provide: PERFECT_SCROLLBAR_CONFIG,
      useValue: DEFAULT_PERFECT_SCROLLBAR_CONFIG
    },
    AuthService,
    AttributeService,
    RobotService,
    AppGlobals
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

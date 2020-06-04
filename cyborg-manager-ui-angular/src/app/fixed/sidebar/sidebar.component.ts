import {
  ChangeDetectorRef,
  Component,
  NgZone,
  OnDestroy,
  ViewChild,
  HostListener,
  Directive,
  AfterViewInit
} from '@angular/core';
import { MediaMatcher } from '@angular/cdk/layout';
import { MenuItems } from '../../fixed/menu-items/menu-items';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';

import {AuthService} from '../../auth/service/auth.service';


@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: []
})
export class AppSidebarComponent implements OnDestroy {
  private authService: AuthService;
  
  mobileQuery: MediaQueryList;
  private _mobileQueryListener: () => void;
  public config: PerfectScrollbarConfigInterface = {};

  constructor(
    authService: AuthService,
    changeDetectorRef: ChangeDetectorRef,
    media: MediaMatcher,
    public menuItems: MenuItems
  ) {
    this.authService = authService;

    this.mobileQuery = media.matchMedia('(min-width: 768px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }

  getUserName(): String{
    return this.authService.getUserName();
  }

  getUserInitials(): String{
    return this.authService.getUserInitials();
  }
}

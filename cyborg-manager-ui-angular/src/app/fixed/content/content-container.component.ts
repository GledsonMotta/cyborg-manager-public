import {
  ChangeDetectorRef,
  Component,
  NgZone,
  OnInit,
  OnDestroy,
  ViewChild,
  HostListener,
  Directive,
  AfterViewInit
} from '@angular/core';
import { MediaMatcher } from '@angular/cdk/layout';
import { MenuItems } from '../../fixed/menu-items/menu-items';
import { SideNavService } from '../sidebar/sidebar.service';
import { MatSidenav } from '@angular/material/sidenav';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';
@Component({
  selector: 'app-content-container',
  templateUrl: './content-container.component.html',
  styleUrls: []
})
export class AppContentContainerComponent implements OnInit,OnDestroy {
  mobileQuery: MediaQueryList;

  @ViewChild('sidenav') public sidenav: MatSidenav;
  
  private _mobileQueryListener: () => void;

  public config: PerfectScrollbarConfigInterface = {};

  constructor(
    changeDetectorRef: ChangeDetectorRef,
    media: MediaMatcher,
    public menuItems: MenuItems,
    private sideNavService: SideNavService
  ) {
    this.mobileQuery = media.matchMedia('(min-width: 768px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }

  ngOnInit() { 
    this.sideNavService.sideNavToggleSubject.subscribe(()=> {
        if(this.sidenav!=undefined){
          this.sidenav.toggle();
          //console.log(this.sidenav.toggle);
        }
     });
   } 
}

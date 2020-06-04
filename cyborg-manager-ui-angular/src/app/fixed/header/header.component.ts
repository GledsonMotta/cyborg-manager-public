import { Component } from '@angular/core';
import { SideNavService } from '../sidebar/sidebar.service';
import {AuthService} from '../../auth/service/auth.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: []
})
export class AppHeaderComponent {
  private authService:AuthService;

  constructor(private sideNavService: SideNavService, authService: AuthService) {
    this.authService = authService;
  }

  toggleMenu() { 
    this.sideNavService.toggle();
  }

  getUserName(){
    return this.authService.getUserName();
  }
}

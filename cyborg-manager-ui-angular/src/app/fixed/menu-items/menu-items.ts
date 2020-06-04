import { Injectable } from '@angular/core';

export interface Menu {
  state: string;
  name: string;
  type: string;
  icon: string;
  child?: MenuItem []
}

export interface MenuItem {
  state: string;
  name: string;
  type: string;
}

const MENUITEMS = [
  { state: 'dashboard', name: 'Dashboard', type: 'link', icon: 'dashboard' },
  { state: 'control-center', type: 'link', name: 'Command Center', icon: 'settings_remote', 
    child: [ 
      { state: 'global-activity', type: 'link', name: 'Global Activity'} 
    ] 
  },
  { state: 'attribute', type: 'link', name: 'Attribute', icon: 'build' },
  { state: 'robot', type: 'link', name: 'Robot', icon: 'accessibility', 
    child: [ 
      { state: 'robot-model', type: 'link', name: 'Robot Models'} 
    ] 
  },
  { state: 'process', type: 'link', name: 'Process', icon: 'account_tree' }
];

@Injectable()
export class MenuItems {
  getMenuitem(): Menu[] {
    return MENUITEMS;
  }
}

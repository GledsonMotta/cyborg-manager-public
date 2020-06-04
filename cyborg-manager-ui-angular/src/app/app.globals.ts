import { Component, Injectable } from '@angular/core';

import { environment } from '../environments/environment';


@Injectable()
export class AppGlobals {
  cybmgrapi_endpoint_url = environment.cybmgrapi_endpoint;
}

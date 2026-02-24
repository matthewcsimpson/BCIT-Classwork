/* import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  template: `<button (click)="getSomeData()">Test GET Request</button>
    <ul>
      <li *ngFor="let myData of namesArray">
        {{ myData.first }} {{ myData.last }}
      </li>
    </ul>`,
})
export class AppComponent {
  namesArray: Array<any> = [];
  _http: HttpClient;

  // Since we are using a provider above we can receive
  // an instance through an instructor.
  constructor(private http: HttpClient) {
    this._http = http;
  }

  getSomeData() {
    this._http
      .get<any>('./assets/test.json')
      // Get data and wait for result.
      .subscribe(
        (result) => {
          this.namesArray = result;
        },

        (error) => {
          // Let user know about the error.
          alert(error);
          console.error(error);
        }
      );
  }
} */

// ----------------------------------------------------------------
/* 
import { Component } from '@angular/core';

// This component consumes the re-usable service.
@Component({
  selector: 'app-root',
  template: `
  <h3>Please enter the customer informatino:</h3>
  <child [callParent]="parentFuncRef"></child>
  {{dataFromChild}}
  `
})
export class AppComponent {
  parentFuncRef!: Function;
  operations!: Array<any>;
  dataFromChild!: string;

  // This function is called by the Angular framework after
  // the constructor executes.
  public ngOnInit() { 
    this.parentFuncRef = this.myCallBackFunction.bind(this);
  }

  // This function can be called by child.
  public myCallBackFunction(streetAddress: string, city: string, region: string) {
    this.dataFromChild = 
          "Street Address: " + streetAddress + " " +
          "City: " + city + ", Region: " + region;
  }
}
 */

/* import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls:  ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  myMouseEnter() {
    console.log("Mouse entered!")
  };

  myMouseLeave() {
    console.log("Mouse Left!!")
  }
} */

/* import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Week Three';
  keyupChar!: string;
  keyupString: string = 'KEYS PRESSED: ';

  myKeyDown(event: { key: any }) {
    console.log(event);
    console.log(event.key);
  }

  myKeyUp(event: { key: any }) {
    console.log(event);
    console.log(event.key);
    this.keyupChar = event.key;
    this.keyupString = this.keyupString + event.key;
  }
} */

/* import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  myFocusEvent(description: any) {  
    console.log(description)
  }
}
 */

/* import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  myMouseHandler(event: any, description: any) {      
    console.log(description + " X: " + event.screenX.toString()
                            + " Y:" + event.screenY.toString());
  }
  
}
 */

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'app';
}

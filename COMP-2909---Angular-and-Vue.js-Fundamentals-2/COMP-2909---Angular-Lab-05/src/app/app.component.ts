/* import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `<label [class.danger]="foodWarning">Has food allergy.</label>
    <input type="checkbox" [(ngModel)]="foodWarning" /> <br />
    <label [class.green]="makeGreen">Make me green.</label>
    <input type="checkbox" [(ngModel)]="makeGreen" />`,

  styles: [
    `
      .danger {
        color: orange;
        font-weight: bold;
      }

      .green {
        color: green;
        font-weight: bold;
        font-size: 150%;
      }
    `,
  ],
})
export class AppComponent {
  foodWarning: Boolean;
  makeGreen: Boolean;
  constructor() {
    // Set default value to false.
    this.foodWarning = false;
    this.makeGreen = false;
  }
}
 */

// ----------------------------------------------------------

/* import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `<p [ngClass]="myClasses">class binding example</p>`,
  styles: [`
    .warning {
      font-weight:bold;
    }
    .danger {
      color:red; 
    }
    .highrisk {
      text-decoration:underline;
    }
    `
  ]
})
export class AppComponent {
  title = 'app';
  property1=true;
  property2=true;
  property3=true;
  myClasses =  {
    warning:this.property1,
    danger:this.property2,
    highrisk:this.property3
  }
}
 */

// ----------------------------------------------------------

/* import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <input
      type="checkbox"
      [(ngModel)]="doesNotExercise"
      (change)="adjustCSS()"
    />Does not exercise.
    <input type="checkbox" [(ngModel)]="over55" (change)="adjustCSS()" />
    Is over 55.
    <div *ngIf="doesNotExercise || over55" [ngClass]="myClasses">
      Is at risk of heart disease.
    </div>
  `,
  styles: [
    `
      .warning {
        font-weight: bold;
      }
      .danger {
        color: red;
      }
    `,
  ],
})
export class AppComponent {
  title = 'app';
  doesNotExercise = false;
  over55 = false;

  myClasses = {
    warning: false,
    danger: false,
  };
  adjustCSS() {
    if (this.doesNotExercise && this.over55) {
      this.myClasses.warning = true;
      this.myClasses.danger = true;
    } else {
      this.myClasses.warning = false;
      this.myClasses.danger = false;
    }
  }
}
 */

// ----------------------------------------------------------


/* import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `<p [ngStyle]="myStyles">style binding example</p>`,

})
export class AppComponent {
  myStyles = {
    'color':'red',
    'font-weight':'bold'
  }
} */

// ----------------------------------------------------------

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `<p [style.font-weight]="myWeight" [style.color]="myColor">style binding example</p>`,

})
export class AppComponent {
  myWeight = "bold";
  myColor = "blue";
}

// ----------------------------------------------------------

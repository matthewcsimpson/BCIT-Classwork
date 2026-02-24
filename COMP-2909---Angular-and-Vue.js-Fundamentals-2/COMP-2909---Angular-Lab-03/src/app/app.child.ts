import { Component, Input } from '@angular/core';

@Component({
  selector: 'child',
  template: `
    <table>
    <tr>
        <td>Stree Address: </td>
        <td>&nbsp;&nbsp;</td>
        <td><input type='text' [(ngModel)]="streetAddress"></td>
    </tr>
    <tr>
        <td>City: </td>
        <td>&nbsp;&nbsp;</td>
        <td><input type='text' [(ngModel)]="city"></td>
    </tr>
    <tr>
        <td>Region: </td>
        <td>&nbsp;&nbsp;</td>
        <td><input type='text' [(ngModel)]="region"></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td><input type="submit" (click)="submitInput()"/></td>
    </tr>
    </table>
  `
})
export class ChildComponent {
    streetAddress!: string;
    city!: string;
    region!: string;

    @Input() // Reference to parent function. Ref provided by parent.
    callParent!: Function;

    submitInput() {
        this.callParent(this.streetAddress, this.city, this.region);
    }
}

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Calculator';

  sumFirstNumber!: string;
  sumSecondNumber!: string;

  diffFirstNumber!: string;
  diffSecondNumber!: string;

  prodFirstNumber!: string;
  prodSecondNumber!: string;

  quotFirstNumber!: string;
  quotSecondNumber!: string;

  currentOperator!: number;

  summation!: string;
  difference!: string;
  product!: string;
  quotient!: string;

  doAdd() {
    let num1 = Number(this.sumFirstNumber);
    let num2 = Number(this.sumSecondNumber);
    let sum = num1 + num2;
    let output =
      num1 +
      ' + ' +
      num2 +
      ' = ' +
      Math.round((sum + Number.EPSILON) * 100) / 100;

    console.log(output);
    this.summation = output;
    this.sumFirstNumber = '';
    this.sumSecondNumber = '';
    this.currentOperator = 0;
    this.clearResults(this.currentOperator);
    return output;
  }

  doSubtract() {
    let num1 = Number(this.diffFirstNumber);
    let num2 = Number(this.diffSecondNumber);
    let diff = num1 - num2;
    let output =
      num1 +
      ' - ' +
      num2 +
      ' = ' +
      Math.round((diff + Number.EPSILON) * 100) / 100;

    console.log(output);
    this.difference = output;
    this.diffFirstNumber = '';
    this.diffSecondNumber = '';
    this.currentOperator = 1;
    this.clearResults(this.currentOperator);
    return output;
  }

  doProduct() {
    let num1 = Number(this.prodFirstNumber);
    let num2 = Number(this.prodSecondNumber);
    let prod = num1 * num2;
    let output =
      num1 +
      ' * ' +
      num2 +
      ' = ' +
      Math.round((prod + Number.EPSILON) * 100) / 100;

    console.log(output);
    this.product = output;
    this.prodFirstNumber = '';
    this.prodSecondNumber = '';
    this.currentOperator = 2;
    this.clearResults(this.currentOperator);
    return output;
  }

  doQuotient() {
    let num1 = Number(this.quotFirstNumber);
    let num2 = Number(this.quotSecondNumber);
    let quot = num1 / num2;
    let output =
      num1 +
      ' ÷ ' +
      num2 +
      ' = ' +
      Math.round((quot + Number.EPSILON) * 100) / 100;

    console.log(output);
    this.quotient = output;
    this.quotFirstNumber = '';
    this.quotSecondNumber = '';
    this.currentOperator = 3;
    this.clearResults(this.currentOperator);
    return output;
  }

  clearResults(index: number) {
    switch (index) {
      case 0:
        this.difference = '';
        this.product = '';
        this.quotient = '';
        break;
      case 1:
        this.summation = '';
        this.product = '';
        this.quotient = '';
        break;
      case 2:
        this.summation = '';
        this.difference = '';
        this.quotient = '';
        break;
      case 3:
        this.summation = '';
        this.difference = '';
        this.product = '';
        break;
    }
  }
}

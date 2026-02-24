import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Homework02 - Fruit Store';
  firstName!: string;
  lastName!: string;
  streetAddress!: string;
  orderInfoString!: string;
  groceryItem!: string;
  groceryQty!: number;
  id!: number;
  delItem!: number;

  shoppingList: Array<any>;
  constructor() {
    this.shoppingList = [];
    this.id = 0;
  }

  subTotal!: string;
  tax!: string;
  totalPrice!: string;

  grocerylist = [
    { item: 'Apples', cost: 1.5 },
    { item: 'Peaches', cost: 1.25 },
    { item: 'Pears', cost: 1.5 },
    { item: 'Plums', cost: 1.75 },
  ];

  orderDetails() {
    this.orderInfoString =
      'Order for: ' +
      this.firstName +
      ' ' +
      this.lastName +
      ' At: ' +
      this.streetAddress;
  }

  addItem() {
    console.log('Item: ' + this.groceryItem + ' qty: ' + this.groceryQty);
    let unitPrice = 0;
    for (let i = 0; i < this.grocerylist.length; i++) {
      if (this.grocerylist[i].item === this.groceryItem) {
        unitPrice = this.grocerylist[i].cost;
      }
    }
    let sList = this.shoppingList;

    let newItem = {
      id: this.id,
      name: this.groceryItem,
      price: unitPrice,
      qty: this.groceryQty,
      totPrice: unitPrice * this.groceryQty,
    };
    this.id += 1;

    sList.push(newItem);
    console.log(newItem);
    this.shoppingList = sList;
    this.calcSubTotal();
  }

  calcSubTotal() {
    let sList = this.shoppingList;
    let sub = 0;
    for (let i = 0; i < sList.length; i++) {
      sub += sList[i].totPrice;
      console.log('running subtotal: ' + sub);
    }
    this.subTotal = '$' + Math.round((sub + Number.EPSILON) * 100) / 100;
    this.calcTaxAndTotal(sub);
  }

  calcTaxAndTotal(subtotal: number) {
    let rate = 0.07;
    let taxIn = subtotal * rate;
    this.tax = '$' + Math.round((taxIn + Number.EPSILON) * 100) / 100;
    let total = taxIn + subtotal;
    this.totalPrice = '$' + Math.round((total + Number.EPSILON) * 100) / 100;
  }

  removeItem(){
    console.log("Delete Item: ");
  }

}

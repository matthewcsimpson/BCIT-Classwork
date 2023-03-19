const v = require("./orderValidator");

test("crust type selected", () => {
  console.log("1-------------------------------TEST FOR CRUST");
  expect(v.validateCrust(orderOne)).not.toBeNull();
});

test("no crust selected", () => {
  console.log("2-------------------------------TEST FOR NO CRUST");
  expect(v.validateCrust(orderTwo)).toBeFalsy();
});

test("test a correct size", () => {
  console.log("3-------------------------------TEST FOR CORRECT SIZES");
  sizeTest = v.validateSize(orderTwo);
  expect(sizeTest).toBeTruthy();
});

test("test an icorrect size", () => {
  console.log("4-------------------------------TEST FOR INCORRECT SIZES");
  orderTwo.pizzaSize = 2;
  sizeTest = v.validateSize(orderTwo);
  expect(sizeTest).toBeFalsy();
});

test("toppings present", () => {
    console.log("5-------------------------------TEST FOR TOPPINGS");
    expect(v.validateToppings(orderOne)).toBeTruthy();
});

test("toppings not present", () => {
    console.log("6-------------------------------TEST FOR NO TOPPINGS");
    expect(v.validateToppings(orderSix)).toBeFalsy();
});

test("phone number  present and NOT valid", () => {
    console.log("7-------------------------------TEST BAD PHONE NUMBER");
    let num = v.validatePhone(orderSix);
    expect(num).toBeFalsy();
});

test("phone number present and valid", () => {
    console.log("8-------------------------------TEST BAD PHONE NUMBER");
    orderSix.phoneNumber = "123-456-7890";
    expect(v.validatePhone(orderSix)).toBeTruthy();
});

test("phone number NOT present", () => {
    console.log("9-------------------------------TEST NO PHONE NUMBER");
    orderSix.phoneNumber = "";
    expect(v.validatePhone(orderSix)).toBeFalsy();
});

test("postal code", () => {
    console.log("10-------------------------------TEST POSTAL CODE");
    orderSix.address = "1234 any street, v6x 1l6";
    expect(v.validatePostalCode(orderSix)).toBeTruthy();
});

test("NO postal code", () => {
    console.log("10-------------------------------TEST NO POSTAL CODE");
    expect(v.validatePostalCode(orderOne)).toBeFalsy();
});



// --------------------------------------- DATA
let orderOne = {
  customerName: "Johnny One",
  phoneNumber: "1232343456",
  address: "1234 Any Street",
  pizzaSize: "14",
  typeOfCrust: "White",
  meatToppings: ["Pepporoni"],
  veggieToppings: ["Onion"],
  quantity: 1,
};

let orderTwo = {
  customerName: "Johnny One",
  phoneNumber: "1232343456",
  address: "1234 Any Street",
  pizzaSize: "14",
  typeOfCrust: "",
  meatToppings: ["Pepporoni"],
  veggieToppings: ["Onion"],
  quantity: 1,
};

//   let orderThree = {
//     customerName: 'Johnny 6',
//     phoneNumber: '1233456789',
//     address: '1234 Any Street',
//     pizzaSize: '14',
//     typeOfCrust: 'White',
//     meatToppings: [ 'Pepporoni', 'Beef', 'Sausage', 'Chicken' ],
//     veggieToppings: [],
//     quantity: 1,
//     status: 'created',
//     subTotal: '33.50',
//     total: '37.52'
//   }

//   let orderFour = {
//     customerName: 'Johnny 7 ',
//     phoneNumber: '2463471234',
//     address: '1234 West 15th ',
//     pizzaSize: '14',
//     typeOfCrust: 'White',
//     meatToppings: [],
//     veggieToppings: [ 'Onion', 'Green', 'Mushroom', 'Olive', 'Tomato' ],
//     quantity: 1,
//     status: 'created',
//     //subTotal: '41.50',
//     //total: '46.48'
//   }

//   let orderFive = {
//     customerName: 'Johnny 7 ',
//     phoneNumber: '2463471234',
//     address: '1234 West 15th ',
//     pizzaSize: '14',
//     typeOfCrust: 'White',
//     meatToppings: [ 'Pepporoni', 'Beef', 'Sausage', 'Chicken', 'Bacon' ],
//     veggieToppings: [ 'Onion', 'Green', 'Mushroom', 'Olive', 'Tomato' ],
//     quantity: 1,
//     status: 'created',
//     //subTotal: '41.50',
//     //total: '46.48'
//   }

  let orderSix = {
    customerName: 'Johnny 7 ',
    phoneNumber: '2463471234',
    address: '1234 West 15th ',
    pizzaSize: '14',
    typeOfCrust: 'White',
    meatToppings: [  ],
    veggieToppings: [  ],
    quantity: 1,
    status: 'created',
    //subTotal: '41.50',
    //total: '46.48'
 }

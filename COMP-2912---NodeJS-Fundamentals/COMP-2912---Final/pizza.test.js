const c = require("./calculator2");


test("flag order as created", () => {
  console.log("1-------------------------------TEST STATUS");
  c.createStatus(orderOne);
  expect(orderOne.status).toBe("created");
});

test("check ingredient prices", () => {
  console.log("2-------------------------------TEST INGREDIENT (1 EACH) PRICES");
  c.calculatePrice(orderTwo);
  expect(orderTwo.subTotal).toEqual("19.50");
});

test("check meat (x4) prices", () => {
  console.log("3-------------------------------TEST MEAT PRICES");
  c.calculatePrice(orderThree);
  expect(orderThree.subTotal).toEqual("26.00");
});

test("check veggie (x5) prices", () => {
  console.log("4-------------------------------TEST VEGGIE PRICES");
  c.calculatePrice(orderFour);
  expect(orderFour.subTotal).toEqual("26.50");
});

test("most expensive order (all toppings)", () => {
  console.log("5-------------------------------TEST PRICEY PIZZA PRICES");
  c.calculatePrice(orderFive);
  expect(orderFive.subTotal).toEqual("41.50");
});

test("test no toppings", () => {
  console.log("6-------------------------------TEST CHEAP PIZZA PRICES");
  c.calculatePrice(orderSix);
  expect(orderSix.subTotal).toEqual("14.00");
});

test("testing tax calculation", () =>{
  console.log("7-------------------------------TEST ADD TAXES (low cost)");
  c.calculatePrice(orderSix);
  expect(orderSix.total).toEqual("15.68");
});

test("testing tax calculation 2", () =>{
  console.log("8-------------------------------TEST ADD TAXES (high cost)");
  c.calculatePrice(orderFive);
  expect(orderFive.total).toEqual("46.48");
});

test("testing pizza size", () => {
  console.log("9-------------------------------TEST PIZZA SIZES");
  c.calculatePrice(orderOne);
  expect(orderOne.pizzaSize).toEqual("14");
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
  typeOfCrust: "White",
  meatToppings: ["Pepporoni"],
  veggieToppings: ["Onion"],
  quantity: 1,
};

let orderThree = {
  customerName: 'Johnny 6',
  phoneNumber: '1233456789',
  address: '1234 Any Street',
  pizzaSize: '14',
  typeOfCrust: 'White',
  meatToppings: [ 'Pepporoni', 'Beef', 'Sausage', 'Chicken' ],
  veggieToppings: [],
  quantity: 1,
  status: 'created',
  subTotal: '33.50',
  total: '37.52'
}

let orderFour = {
  customerName: 'Johnny 7 ',
  phoneNumber: '2463471234',
  address: '1234 West 15th ',
  pizzaSize: '14',
  typeOfCrust: 'White',
  meatToppings: [],
  veggieToppings: [ 'Onion', 'Green', 'Mushroom', 'Olive', 'Tomato' ],
  quantity: 1,
  status: 'created',
  //subTotal: '41.50',
  //total: '46.48'
}


let orderFive = {
  customerName: 'Johnny 7 ',
  phoneNumber: '2463471234',
  address: '1234 West 15th ',
  pizzaSize: '14',
  typeOfCrust: 'White',
  meatToppings: [ 'Pepporoni', 'Beef', 'Sausage', 'Chicken', 'Bacon' ],
  veggieToppings: [ 'Onion', 'Green', 'Mushroom', 'Olive', 'Tomato' ],
  quantity: 1,
  status: 'created',
  //subTotal: '41.50',
  //total: '46.48'
}

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





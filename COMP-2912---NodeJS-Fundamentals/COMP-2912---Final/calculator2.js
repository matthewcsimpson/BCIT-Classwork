const pizzaOptions = require('./pizzaOptions.json');

exports.calculatePrice = function(orderData){
    let totalPrice = 0;
    console.log("------------- CALCULATING PRICE");
    console.log(orderData);

    let size = parseInt(orderData.pizzaSize);
    console.log("SIZE: " + size);

    let meat = orderData.meatToppings.length;
    console.log("MEAT: " + meat)

    let veggies = orderData.veggieToppings.length;
    console.log("VEGGIES: " + veggies)

    let quantity = orderData.quantity;
    console.log("QUANTITY: " + quantity)

    totalPrice = (size + (meat * pizzaOptions.meatToppingPrice) + (veggies * pizzaOptions.veggieToppingPrice)) * quantity;
    orderData.subTotal = totalPrice.toFixed(2);
    console.log("SUBTOTAL PRICE: " + orderData.subTotal);

    orderData.total = addTax(totalPrice);
    console.log("TOTAL: " + orderData.total);
    return orderData;
}

const addTax = (subTotal) => {
    return (totalPrice = subTotal * (1+pizzaOptions.salesTax)).toFixed(2);
}

exports.createStatus = function(orderData){
    orderData.status = "created";
    return orderData;
}
const pizzaOptions = require('./pizzaOptions.json');

exports.calculateTotal = function(orderData){
    let totalPrice = 0;
    console.log("Calculating total price");
    for(let size of pizzaOptions.size){
        if(size.name === orderData.size){
            console.log(size.name + ": $" + size.cost);
            totalPrice += size.cost;
        }
    }
    for(let crust of pizzaOptions.crusts){
        if(crust.name === orderData.crust){
            console.log(crust.name + ": $" + crust.cost);
            totalPrice += crust.cost;
        }
    }
    if(orderData.toppings){
    for(let toppings of pizzaOptions.toppings){
        for(let toppingsChoices of orderData.toppings){
            if(toppings.name === toppingsChoices){
                console.log(toppings.name + ": $" + toppings.cost);
                totalPrice += toppings.cost;
            }
        }
    }
    console.log("done calculating price");

    orderData.totalPrice = totalPrice;
    
}
//    console.log("total price: $" + totalPrice);
    return orderData;
}

exports.setOrderID = function(orderData){
    let now = new Date();
    orderData.orderID = now;
    orderData.orderTime = now.setMinutes(now.getMinutes() + 30);
    console.log("add order ID");
    console.log(orderData);
    return orderData;
}
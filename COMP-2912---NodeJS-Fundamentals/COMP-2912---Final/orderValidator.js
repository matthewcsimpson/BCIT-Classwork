const p = require("./pizzaOptions.json");
const c = require("./calculator2");
const pnRegex = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$/;
const pcRegex = /[ABCEGHJ-NPRSTVXY]\d[ABCEGHJ-NPRSTV-Z][ -]?\d[ABCEGHJ-NPRSTV-Z]\d/i;

exports.validateCrust = function (orderData) {
  if (orderData.crust) {
    return true;
  } else {
    return false;
  }
};

exports.validateSize = function (orderData) {
  size = parseInt(orderData.pizzaSize);
  console.log("size:" + size);
  if (size == 14 || size == 10 || size == 8) {
    return true;
  } else {
    return false;
  }
};

exports.validateToppings = function (orderData) {
  toppings = orderData.veggieToppings.length + orderData.meatToppings.length;
  if (toppings > 0) {
    return true;
  } else {
    return false;
  }
};

exports.validatePhone = function(orderData){
    console.log("phone number: " + orderData.phoneNumber);
    if(orderData.phoneNumber){
        return pnRegex.test(orderData.phoneNumber);
    }
}

exports.validatePostalCode = function(orderData){
    let pc = orderData.address.match(pcRegex);
    if(pc){
        return true;
    }else {
        return false;
    }
}


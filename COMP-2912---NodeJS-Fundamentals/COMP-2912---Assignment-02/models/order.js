const mongoose = require("mongoose");
const d = require('date-and-time');
let now = new Date();

const Schema = mongoose.Schema;

const orderSchema = new Schema({
  customerName: String,
  phoneNumber: String,
  address: String,
  pizzaSize: String,
  typeOfCrust: String,
  meatToppings: [String],
  veggieToppings: [String],
  quantity: Number,
  subTotal: Number,
  total: Number,
  status: String,
  createdOn: { type: Date, default: Date.now() },
});

module.exports = mongoose.model("Order", orderSchema);

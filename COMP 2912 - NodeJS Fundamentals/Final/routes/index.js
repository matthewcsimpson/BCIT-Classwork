const express = require("express");
const router = express.Router();
const { check, validationResult } = require("express-validator");

const pizzaOptions = require("../pizzaOptions");
const c = require("../calculator2");
const Order = require("../models/order");
const d = require('date-and-time');

/* GET home page. */
router.get("/", function (req, res, next) {
  res.render("index", { title: "Assignment 2 - Pizza Order w/ Database", pizzaOptions });
});

/* GET order page. */
router.get("/orders", function (req, res, next) {
  res.render("orders", { title: "Orders in the Database" });
});

/* API methods */
router.post(
  "/api/orders",
  [
    check("customerName").not().isEmpty(),
    check("phoneNumber").not().isEmpty(),
    check("address").not().isEmpty(),
  ],
  (req, res) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(422).json({ errors: errors.array() });
    }

    let orderInfo = req.body;
    console.log("---------------------------ORDER DATA: ");
    orderInfo = c.createStatus(orderInfo);
    console.log(orderInfo);
    
    orderInfo = c.calculatePrice(orderInfo);
    console.log(orderInfo)

    order = new Order(orderInfo);
    order.save((err) => {
      if (err) {
        console.log(err);
        res.status(500).json({ msg: "Error adding the order" });
        return;
      }
      res.json({ status: "Successfully added a order" });
    });
  }
);

router.get("/api/orders", (req, res) => {
  Order.find({}, (err, orders) => {
    if (err) {
      console.log(err);
      res.status(500).json({ msg: "Error retrieving orders" });
      return;
    }
    res.json(orders);
  });
});

router.get("/api/orders/:searchName", (req, res) => {
  var name = req.params.searchName;
  Order.find({ customerName: name }, (err, result) => {
    if (err) {
      console.log(err);
      res.status(500).json({ msg: "Error retrieving orders" });
      return;
    }
    console.log(result);
    res.json(result);
  });
});

router.get("/api/orders/phone/:searchPhone", (req, res) => {
  var phone = req.params.searchPhone;
  Order.find({ phoneNumber: phone }, (err, result) => {
    if (err) {
      console.log(err);
      res.status(500).json({ msg: "Error retrieving orders" });
      return;
    }
    console.log(result);
    res.json(result);
  });
});

module.exports = router;

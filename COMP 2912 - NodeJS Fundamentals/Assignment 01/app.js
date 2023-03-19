const express       = require('express');
const path          = require('path');
const pizzaOptions  = require('./pizzaOptions');
const c             = require('./calculator');
const fs            = require('fs');
const valdator      = require('express-validator');
const checker       = require('express-validator/check');

const app = express();

//Static Middleware
app.use(express.static('public'));

//Body parser middleware
app.use(express.urlencoded({extended : true}));

//configure handlebars
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'hbs');

app.get('/', (req, res) => {
    res.render('index', {title: 'Assignment 1 - Pizza Order', pizzaOptions});
});

app.post('/order', 
[
    checker.body('customerName', "please enter a name").exists().not().isEmpty().withMessage("name is required!"), 
    checker.body('phoneNumber', 'please enter a phone number').exists().not().isEmpty().withMessage("must enter a phone number!").isMobilePhone('any'), 
    checker.body('emailAddress', "please enter a valid email address").exists().not().isEmpty().withMessage("must use valid email").isEmail().normalizeEmail()
], 

(req, res) => {
    let orderDetails = req.body;
    const errors = checker.validationResult(req);
    const errorMessages = errors.mapped();
    console.log("errors")
    console.log(errorMessages);
    console.log("end log errors")

    if(errors.isEmpty()){
        orderDetails = c.calculateTotal(orderDetails);
        console.log("order details");
        console.log(orderDetails);
        console.log("end order details");
        res.render('order', {orderDetails});
    }else{
        res.render('index', {
            title: "Your Order has Errors!",
            orderDetails, pizzaOptions, errorMessages,
            phoneErr: errorMessages.hasOwnProperty('phoneNumber') ? errorMessages.phoneNumber.msg : null,
            nameErr: errorMessages.hasOwnProperty('customerName') ? errorMessages.customerName.msg : null,
            emailErr: errorMessages.hasOwnProperty('emailAddress') ? errorMessages.emailAddress.msg : null

        })

    }

});

app.post('/send', (req, res) => {
    let orderDetails = req.body;
    console.log("/send order details");
    console.log(orderDetails);
    console.log("/send end order details");
    orderSpecifics = c.setOrderID(orderDetails);
    orderSpecificsString = JSON.stringify(orderSpecifics);

    res.render('send', {orderSpecifics});

    fs.writeFile(`./order-${orderSpecifics.orderID}.json`, orderSpecificsString, err => {
        if(err){
            console.log(err)
            return;
        }
    })
});



app.listen(3000, () => {
    console.log('listening on port 3000');
});
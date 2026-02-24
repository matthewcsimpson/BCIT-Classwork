$(function ready() {
  $.getJSON("/api/orders", function (orderData) {
    if (orderData != null) {
      $("#orders").append(tableString);
      orderData.forEach(function (orderItem) {
        $("#orders").append(
          "<tr><td>" +
            orderItem.customerName +
            "</td><td>" +
            orderItem.phoneNumber +
            "</td><td>" +
            orderItem.address +
            "</td><td>" +
            orderItem.pizzaSize +
            "</td><td>" +
            orderItem.typeOfCrust +
            "</td><td>" +
            orderItem.meatToppings +
            "</td><td>" +
            orderItem.veggieToppings +
            "</td><td>" +
            orderItem.quantity +
            "</td><td>" +
            orderItem.subTotal +
            "</td><td>" +
            orderItem.total +
            "</td><td>" +
            orderItem.status +
            "</td>" +
            "</tr>"
        );
      });
    }
  });

  $("#searchCustomerName").submit(function (event) {
    event.preventDefault();

    const requestURL = "/api/orders/" + $("#searchName").val();
    //clear input for next search use. Enhance UX.
    $("#searchName").val("");

    $.ajax({
      url: requestURL,
      type: "GET",
      contentType: "application/json",
      dataType: "json",

      success: function (json, status, request) {
        $("#orders").empty();
        $("#orders").append(tableString);
        json.forEach(function (orderItem) {
          $("#orders").append(
            "<tr><td>" +
              orderItem.customerName +
              "</td><td>" +
              orderItem.phoneNumber +
              "</td><td>" +
              orderItem.address +
              "</td><td>" +
              orderItem.pizzaSize +
              "</td><td>" +
              orderItem.typeOfCrust +
              "</td><td>" +
              orderItem.meatToppings +
              "</td><td>" +
              orderItem.veggieToppings +
              "</td><td>" +
              orderItem.quantity +
              "</td><td>" +
              orderItem.subTotal +
              "</td><td>" +
              orderItem.total +
              "</td><td>" +
              orderItem.status +
              "</td>" +
              "</tr>"
          );
        });
      },
      error: function (request, status) {
        $("#statusMsg").removeClass();
        $("#statusMsg").addClass("alert alert-danger");
        $("#statusMsg").html("Error with search");
        console.log("Request failed : ", status);
      },
    });
  });
  
});


const tableString =
  "<thead><tr><th>Customer Name</th>" +
  "<th>Phone number</th>" +
  "<th>Address</th>" +
  "<th>Pizza size</th>" +
  "<th>Type of crust</th>" +
  "<th>Meat Toppings</th>" +
  "<th>Veggie Toppings</th>" +
  "<th>Quantity</th>" +
  "<th>Subtotal</th>" +
  "<th>Total</th>" +
  "<th>Status</th></tr></thead>";

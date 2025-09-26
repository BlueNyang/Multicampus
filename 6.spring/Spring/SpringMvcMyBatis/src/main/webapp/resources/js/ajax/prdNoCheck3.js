$(function () {
  $("#prdNoCheckBtn").on("click", function (event) {
    event.preventDefault();

    const prdNo = $("#prdNo").val();

    if (prdNo === "") {
      alert("Enter a product number.");
      return false;
    } else {
      $.ajax({
        type: "GET",
        url: "/SpringMvcMyBatis/product/prdNoCheck3",
        data: {prdNo: prdNo},
        dataType: "text",
        success: (response) => {
          console.log(response);
          if (response === "available") {
            alert("The product number is available.");
          } else {
            alert("The product number is already in use.");
          }
        },
        error: (error) => {
          console.log(error);
          alert("An error occurred while requesting the server.");
        }
      })
    }

  })
})
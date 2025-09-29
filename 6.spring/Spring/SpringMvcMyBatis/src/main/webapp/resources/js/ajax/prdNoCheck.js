$(function () {
  $("#prdNoCheckBtn").on("click", function (event) {
    event.preventDefault();

    const prdNo = $("#prdNo").val();

    if (prdNo === "") {
      alert("Enter a product number.");
      return false;
    } else {
      $.ajax({
        type: "POST",
        url: "/SpringMvcMyBatis/product/prdNoCheck",
        data: {
          prdNo: prdNo
        },
        dataType: "text",
        success: (response) => {
          console.log(response);
          if (response === "available") {
            alert("The product number is available.");
          } else {
            alert("The product number is already in use.");
            return false;
          }
        },
        error: (error) => {
          console.log(error);
          alert("An error occurred while requesting the server.");
          return false;
        }
      });

      if (!confirm("해당 상품번호로 등록하시겠습니까?")) {
        return false;
      }

      $("#prdForm").submit();
    }
  });
});
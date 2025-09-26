$(function () {
  $("#prdSearchFrm1").on("submit", function (event) {
    event.preventDefault();

    const formData = $(this).serialize();

    const keyword = $("#keyword").val();
    const type = $("#type").val();

    if (keyword === "" || type === "") {
      alert("검색어와 타입을 모두 입력해주세요.");
      return false;
    }

    $.ajax({
      type: "POST",
      url: "/SpringMvcMyBatis/product/productSearch1",
      data: formData,
      success: function (response) {
        console.log(response);
      },
      error: function () {
        alert("요청 실패");
      }
    });
  });
});
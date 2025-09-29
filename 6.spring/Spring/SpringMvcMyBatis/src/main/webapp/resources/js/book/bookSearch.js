$(function () {
  $("#bookSearchFrm").on(
    "submit",

    (e) => {
      e.preventDefault();

      const data = $(this).serialize();

      const searchValue = $("#searchValue").val();
      const searchType = $("#searchType").val();

      if (searchValue === "" || searchType === "") {
        alert("검색어와 타입을 모두 입력해주세요.");
        return false;
      }

      $.ajax({
        type: "POST",
        url: "/SpringMvcMyBatis/book/searchBook",
        data: data,
        success: function (resp) {
          $("#searchResultBox").html(resp)
        },
        error: function () {
          alert("요청 실패");
        }
      });
    });
});
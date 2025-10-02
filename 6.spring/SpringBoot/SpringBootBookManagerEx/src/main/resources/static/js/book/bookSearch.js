$(function () {
  const $bookSearchFrm = $("#bookSearchFrm");
  $bookSearchFrm.on(
    "submit",

    (e) => {
      e.preventDefault();

      const formData = $bookSearchFrm.serialize();

      const searchType = $("#searchType").val();
      const searchValue = $("#searchValue").val();

      if (searchValue === "" || searchType === "") {
        alert("검색어와 타입을 모두 입력해주세요.");
        return false;
      }

      $.ajax({
        type: "POST",
        url: "/book/searchBook",
        data: formData,
        success: function (resp) {
          $("#searchResultBox").html(resp)
        },
        error: function () {
          alert("요청 실패");
        }
      });
    });
});
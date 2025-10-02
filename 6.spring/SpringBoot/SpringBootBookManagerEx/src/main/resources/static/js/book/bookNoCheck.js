$(function () {
  const $insertBookForm = $("#insertBookForm");
  $("#insertBookSubmitBtn").on(
    "click",
    (e) => {
      e.preventDefault();

      const bookNo = $("#bookNo").val().trim();

      if (bookNo === "") {
        alert("상품번호를 입력하세요.");
        return false
      } else {
        axios.get(
          `/book/bookNoCheck`,
          {params: {bookNo: bookNo}}
        ).then((res) => {
          console.log(res);
          if (res.data === "available") {
            alert("사용 가능한 상품번호입니다.");
          } else {
            alert("이미 사용 중인 상품번호입니다.");
            return false;
          }

          if (!confirm("해당 상품번호로 등록하시겠습니까?")) {
            return false;
          }

          $insertBookForm.submit();
          return true;
        }).catch((err) => {
          console.error(err);
          alert("상품번호 중복 확인에 실패했습니다. 다시 시도해주세요.");
          return false;
        });
      }
    });
});
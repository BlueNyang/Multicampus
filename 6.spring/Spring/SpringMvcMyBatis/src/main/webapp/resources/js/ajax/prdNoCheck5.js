$(function () {
  $("#prdNoCheckBtn").on("click", function (event) {
    event.preventDefault();

    const prdNo = $("#prdNo").val().trim();

    if (prdNo === "") {
      alert("상품번호를 입력하세요.");
      return false
    } else {
      axios.get(
        `/SpringMvcMyBatis/product/prdNoCheck5`,
        {params: {prdNo: prdNo}}
      ).then((res) => {
        if (res.data === "available") {
          alert("사용 가능한 상품번호입니다.");
        } else {
          alert("이미 사용 중인 상품번호입니다.");
          return false;
        }
      }).catch((err) => {
        console.error(err);
      });

      if (!confirm("해당 상품번호로 등록하시겠습니까?")) {
        return false;
      }

      $("#prdForm").submit();
      return true;
    }
  });
});
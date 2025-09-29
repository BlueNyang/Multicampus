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
        const $searchResultBox = $("#searchResultBox");

        $searchResultBox.empty();
        $searchResultBox.append('<table id="resultTable"><tr><th>상품번호</th><th>상품명</th><th>가격</th><th>제조사</th><th>재고</th><th>제조일</th><th>사진</th></tr></table>');
        const $resultTable = $("#resultTable");
        let row;
        if (response.length === 0) {
          row = `<tr><td colspan="7">검색 결과가 없습니다.</td></tr>`;
        } else {
          response.forEach(function (product) {
            const prdDate = new Date(product.prdDate);
            row += `<tr>
  <td>
    <a href="/product/productDetailView/${product.prdNo}">
      ${product.prdNo}
    </a>
  </td>
  <td>${product.prdName}</td>
  <td>${product.prdPrice}</td>
  <td>${product.prdCompany}</td>
  <td>${product.prdStock}</td>
  <td>${prdDate.toLocaleDateString()}</td>
  <td><img src="/SpringMvcMyBatis/images/product/${product.prdNo}.jpg" alt="${product.prdName}" width="100"></td>
</tr>`;
          });
        }
        $resultTable.append(row);

      },
      error: function () {
        alert("요청 실패");
      }
    });
  });
});
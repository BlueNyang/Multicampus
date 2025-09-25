<%--@elvariable id="prd" type="kr.bluenyang.practice.product.model.ProductVO"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>상품 상세 정보 조회</title>
    <style>
      body {
        display: flex;
        flex-direction: column;
        width: 80%;
        align-items: center;
        text-align: center;
        margin: 0 auto;
      }

      table {
        width: 50%;
        margin: auto;
      }

      table, th, td {
        border: 1px solid #777;
        border-collapse: collapse;
      }

      th, td {
        padding: 10px;
      }

      th:first-child {
        width: 150px;
      }

      th {
        background-color: #bbb;
      }

      .links {
        width: 60%;
        display: inline-flex;
        align-items: center;
        justify-content: space-between;
        margin-bottom: 20px;
      }

      a {
        flex: 1;
      }

      .product-img {
        width: auto;
        height: 180px;
      }
    </style>
  </head>
  <body>
    <h3>상품 상세 정보 조회</h3>
    <div class="links">
      <!--  index 페이지로 이동 링크 추가 -->
      <a href="<c:url value='/product/listAllProduct'/>">[목록으로 이동]</a>
      <a href="<c:url value='product/updateProductForm/${prd.prdNo}'/>">[상품 정보 수정]</a><br>
      <a href="javascript:deleteCheck();">[상품 정보 삭제]</a><br>
    </div>
    <table>
      <tr>
        <td colspan="2">
          <img class="product-img" src="<c:url value='/images/product/${prd.prdNo}.jpg'/>" alt="상품 이미지">
        </td>
      </tr>
      <tr>
        <th>구분</th>
        <th>내용</th>
      </tr>
      <tr>
        <td>상품번호</td>
        <td>${prd.prdNo}</td>
      </tr>
      <tr>
        <td>상품명</td>
        <td>${prd.prdName}</td>
      </tr>
      <tr>
        <td>가격</td>
        <td>${prd.prdPrice}</td>
      </tr>
      <tr>
        <td>제조회사</td>
        <td>${prd.prdCompany}</td>
      </tr>
      <tr>
        <td>재고</td>
        <td>${prd.prdStock}</td>
      </tr>
      <tr>
        <td>제조일</td>
        <td><fmt:formatDate value="${prd.prdDate}" pattern="YYYY-MM-dd"/></td>
      </tr>
    </table>

    <!-- 삭제 확인 메시지 출력 -->
    <script>
      function deleteCheck() {
        let answer = confirm("삭제하시겠습니까?");
        if (answer) {
          location.href = "/product/deleteProduct/${prd.prdNo}";
        }
      }
    </script>
  </body>
</html>
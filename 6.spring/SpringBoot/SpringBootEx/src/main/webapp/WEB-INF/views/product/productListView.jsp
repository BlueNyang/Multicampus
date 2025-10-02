<%--@elvariable id="prdList" type="java.util.List"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전제 상품 조회</title>
    <jsp:include page="/WEB-INF/views/layout/head.jsp"/>
    <style>
      body {
        width: 80%;
        margin-inline: auto;
        margin-bottom: 50px;
      }

      table {
        width: 100%;
        border-collapse: collapse;
      }

      th, td {
        border: 1px solid #333;
        padding: 8px;
        text-align: center;
      }

      th {
        background-color: #bbb;
      }

      h3 {
        text-align: center;
      }

      a {
        text-decoration: none;
        color: blue;
      }

      .product-img {
        width: auto;
        height: 100px;
      }

      .nav {
        display: inline-flex;
        justify-content: space-between;
        width: 100%;
        margin-bottom: 10px;
      }
    </style>
  </head>
  <body>
    <h3>전체 상품 조회</h3>
    <div class="nav">
      <a href="<c:url value="/"/>">홈으로 이동</a>
      <a href="<c:url value="/product/productSearchForm"/>">검색하기</a>
      <a href="<c:url value="/product/newProductForm"/>">상품 추가</a>
    </div>
    <table>
      <tr>
        <th>상품번호</th>
        <th>상품명</th>
        <th>상품가격</th>
        <th>제조사</th>
        <th>재고</th>
        <th>사진</th>
      </tr>

      <c:forEach var="prd" items="${prdList}">
        <tr>
          <td><a href="<c:url value="detailProduct/${prd.prdNo}"/>">${prd.prdNo}</a></td>
          <td>${prd.prdName}</td>
          <td>${prd.prdPrice}</td>
          <td>${prd.prdCompany}</td>
          <td>${prd.prdStock}</td>
          <td><img src="<c:url value="/product_images/${prd.prdNo}.jpg"/>" alt="${prd.prdName}" class="product-img"/>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
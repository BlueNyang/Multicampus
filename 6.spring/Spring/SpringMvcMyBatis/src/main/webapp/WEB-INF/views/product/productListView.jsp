<%--@elvariable id="prdList" type="java.util.List"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>전제 상품 조회</title>
    <style>
      body {
        width: 80%;
        margin: 0 auto;
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
    </style>
  </head>
  <body>
    <h3>전체 상품 조회</h3>
    <table>
      <tr>
        <th>상품번호</th>
        <th>상품명</th>
        <th>상품가격</th>
        <th>제조사</th>
        <th>재고</th>
        <th>제조일</th>
        <th>사진</th>
      </tr>

      <!-- 반복문 사용해서 모든 데이터 출력 -->
      <!-- 상품번호에 링크 설정 : /product/detailViewProduct -->
      <!-- 날짜 포맷 설정 : 2025-05-10 형식 -->

      <c:forEach var="prd" items="${prdList}">
        <tr>
          <td><a href="<c:url value="detailProduct/${prd.prdNo}"/>">${prd.prdNo}</a></td>
          <td>${prd.prdName}</td>
          <td>${prd.prdPrice}</td>
          <td>${prd.prdCompany}</td>
          <td>${prd.prdStock}</td>
          <td><fmt:formatDate value="${prd.prdDate}" pattern="YYYY-MM-dd"/></td>
          <td><img src="<c:url value="/images/product/${prd.prdNo}.jpg"/>" alt="${prd.prdName}" class="product-img"/>
          </td>
        </tr>
      </c:forEach>
    </table>
    <br><br>

    <!--  index 페이지로 이동 링크 추가 -->
    <a href="<c:url value="/"/>">홈으로 이동</a>
  </body>
</html>
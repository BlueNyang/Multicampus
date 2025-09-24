<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 24/09/2025
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="bookList" type="java.util.List"--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>전제 도서 조회</title>
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
    </style>
  </head>
  <body>
    <h3>전체 도서 조회</h3>
    <!--  index 페이지로 이동 링크 추가 -->
    <a href="<c:url value="/"/>">홈으로 이동</a>
    <table>
      <tr>
        <th>도서번호</th>
        <th>도서명</th>
        <th>저자</th>
        <th>도서가격</th>
        <th>출간일</th>
        <th>도서 재고</th>
        <th>출판사 번호</th>
      </tr>

      <!-- 반복문 사용해서 모든 데이터 출력 -->
      <!-- 상품번호에 링크 설정 : /product/detailViewProduct -->
      <!-- 날짜 포맷 설정 : 2025-05-10 형식 -->

      <c:forEach var="book" items="${bookList}">
        <tr>
          <td><a href="<c:url value="detailBook/${book.bookNo}"/>">${book.bookNo}</a></td>
          <td>${book.bookName}</td>
          <td>${book.bookAuthor}</td>
          <td>${book.bookPrice}</td>
          <td><fmt:formatDate value="${book.bookDate}" pattern="YYYY-MM-dd"/></td>
          <td>${book.bookStock}</td>
          <td>${book.pubNo}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>

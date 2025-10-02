<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 24/09/2025
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="bookList" type="java.util.List"--%>
<%--@elvariable id="msg" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <title>전제 도서 조회</title>
    <style>
      body {
        width: 80%;
        margin: 0 auto;
      }

      .nav {
        display: inline-flex;
        justify-content: space-between;
        width: 100%;
      }

      table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 50px;
      }

      th, td {
        border: 1px solid #333;
        padding: 8px;
        text-align: center;
      }

      th {
        background-color: #bbb;
      }

      h2 {
        text-align: center;
      }

      a {
        text-decoration: none;
        color: blue;
      }
    </style>
    <c:if test="${not empty msg}">
      <script>
        alert("${msg}");
      </script>
    </c:if>
  </head>
  <body>
    <h2>전체 도서 조회</h2>
    <!--  index 페이지로 이동 링크 추가 -->
    <div class="nav">
      <a href="<c:url value="/"/>">홈으로 이동</a>
      <a href="<c:url value="searchBookForm"/>">도서 검색</a>
      <a href="<c:url value="/book/insertBookForm"/>">도서 추가</a>
    </div>
    <table>
      <tr>
        <th>도서번호</th>
        <th>도서명</th>
        <th>저자</th>
        <th>도서가격</th>
        <th>출간일</th>
        <th>도서 재고</th>
        <th>출판사명</th>
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
          <td>${book.pubName}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>

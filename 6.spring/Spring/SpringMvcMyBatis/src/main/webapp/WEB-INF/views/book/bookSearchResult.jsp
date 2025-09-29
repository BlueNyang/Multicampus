<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 29/09/2025
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="bookList" type="java.util.List"--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Book Search Result</title>
    <style>
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
    </style>
  </head>
  <body>
    <table>
      <thead>
        <tr>
          <th>도서번호</th>
          <th>도서명</th>
          <th>도서 저자</th>
          <th>가격</th>
          <th>출판일</th>
          <th>재고</th>
          <th>출판사명</th>
        </tr>
      </thead>
      <tbody>
        <c:choose>
          <c:when test="${empty bookList}">
            <tr>
              <td colspan="7">검색 결과가 없습니다.</td>
            </tr>
          </c:when>
          <c:otherwise>
            <c:forEach var="book" items="${bookList}">
              <tr>
                <td>
                  <a href="<c:url value="detailBook/${book.bookNo}"/>">
                      ${book.bookNo}
                  </a>
                </td>
                <td>${book.bookName}</td>
                <td>${book.bookAuthor}</td>
                <td>${book.bookPrice}</td>
                <td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-MM-dd"/></td>
                <td>${book.bookStock}</td>
                <td>${book.pubName}</td>
              </tr>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </tbody>
    </table>
  </body>
</html>

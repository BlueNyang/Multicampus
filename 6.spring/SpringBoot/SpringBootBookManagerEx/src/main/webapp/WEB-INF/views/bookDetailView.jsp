<%--@elvariable id="book" type="kr.bluenyang.practice.book.model.BookDTO"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>도서 상세 정보 조회</title>
    <style>
      body {
        display: flex;
        flex-direction: column;
        width: 80%;
        align-items: center;
        text-align: center;
        margin-inline: auto;
      }

      table {
        width: 50%;
        margin-inline: auto;
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
    </style>
  </head>
  <body>
    <h3>도서 상세 정보 조회</h3>
    <div class="links">
      <!--  index 페이지로 이동 링크 추가 -->
      <a href="<c:url value='/book/listAllBook' />">[목록으로 이동]</a>
      <a href="<c:url value='/book/updateBookForm/${book.bookNo}'/>">[도서 정보 수정]</a><br>
      <a href="javascript:deleteCheck();">[도서 정보 삭제]</a><br>
    </div>
    <table>
      <tr>
        <th>구분</th>
        <th>내용</th>
      </tr>
      <tr>
        <td>도서번호</td>
        <td>${book.bookNo}</td>
      </tr>
      <tr>
        <td>도서명</td>
        <td>${book.bookName}</td>
      </tr>
      <tr>
        <td>저 자</td>
        <td>${book.bookAuthor}</td>
      </tr>
      <tr>
        <td>도서가격</td>
        <td>${book.bookPrice}</td>
      </tr>
      <tr>
        <td>출판일</td>
        <td><fmt:formatDate value="${book.bookDate}" pattern="YYYY-MM-dd"/></td>
      </tr>
      <tr>
        <td>재고</td>
        <td>${book.bookStock}</td>
      </tr>
      <tr>
        <td>출판사명</td>
        <td>${book.pubName}</td>
      </tr>
    </table>

    <!-- 삭제 확인 메시지 출력 -->
    <script>
      function deleteCheck() {
        let answer = confirm("삭제하시겠습니까?");
        if (answer) {
          location.href = "<c:url value="/book/deleteBook/${book.bookNo}"/>";
        }
      }
    </script>
  </body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <title>상품 검색</title>
    <script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
    <script src="<c:url value='/js/book/bookSearch.js'/>"></script>
    <style>
      body {
        width: 80%;
        margin: 0 auto;
      }

      .container {
        width: 100%;
        margin: 0 auto;
      }

      #bookSearchFrm {
        margin-top: 20px;
      }

      #bookSearchFrm select,
      #bookSearchFrm input[type="text"] {
        padding: 5px;
        margin-right: 5px;
      }

      #bookSearchFrm input[type="submit"] {
        padding: 5px 15px;
        background-color: #44f;
        color: white;
        border: none;
        cursor: pointer;
      }

      #bookSearchFrm input[type="submit"]:hover {
        background-color: #77f;
      }

      #searchResultBox {
        margin-top: 20px;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h3>도서 검색</h3>
      <a href="<c:url value='/book/listAllBook'/>">목록으로 이동</a>
      <form id="bookSearchFrm">
        <label for="searchType"></label>
        <select id="searchType" name="searchType">
          <option value="">검색 조건 선택</option>
          <option value="bookName">도서명</option>
          <option value="pubName">출판사명</option>
        </select>

        <label for="searchValue"></label>
        <input type="text" name="searchValue" id="searchValue">

        <input type="submit" value="검색">
      </form>
      <br><br>

      <!-- 검색 결과 출력 -->
      <div id="searchResultBox"></div>
    </div>
  </body>
</html>






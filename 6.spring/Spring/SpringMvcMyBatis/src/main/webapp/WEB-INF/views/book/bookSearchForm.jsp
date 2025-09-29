<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>상품 검색</title>
    <script src="<c:url value='/resources/js/jquery-3.7.1.min.js'/>"></script>
    <script src="<c:url value='/resources/js/book/bookSearch.js'/>"></script>
  </head>
  <body>
    <h3>상품 검색</h3>
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
    <br><br>
  </body>
</html>






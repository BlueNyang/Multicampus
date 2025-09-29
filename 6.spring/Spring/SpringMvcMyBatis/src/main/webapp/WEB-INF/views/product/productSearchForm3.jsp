<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>상품 검색</title>
    <script src="<c:url value='/resources/js/jquery-3.7.1.min.js'/>"></script>
    <script src="<c:url value='/resources/js/ajax/productSearch3.js'/>"></script>
  </head>
  <body>
    <h3>상품 검색</h3>
    <a href="<c:url value='/product/listAllProduct'/>">목록으로 이동</a>
    <form id="prdSearchFrm1">
      <label for="type"></label>
      <select id="type" name="type">
        <option value="">검색 조건 선택</option>
        <option value="prdName">상품명</option>
        <option value="prdCompany">제조회사</option>
      </select>

      <label for="keyword"></label>
      <input type="text" name="keyword" id="keyword">

      <input type="submit" value="검색">
    </form>
    <br><br>

    <!-- 검색 결과 출력 -->
    <div id="searchResultBox"></div>
    <br><br>
  </body>
</html>






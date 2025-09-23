<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>상품 검색</title>
  </head>
  <body>
    <h3>상품 검색</h3>
    <form method="post" action="<c:url value='/sec03/product/productSearch'/>">
      <label for="type"></label>
      <select id="type" name="type">
        <option value="">검색 조건 선택</option>
        <option value="no">상품번호</option>
        <option value="name">상품명</option>
        <option value="price">가격</option>
        <option value="company">제조회사</option>
      </select>

      <label for="keyword"></label>
      <input type="text" name="keyword" id="keyword" placeholder="검색어 입력">
      <input type="submit" value="검색">
    </form>
  </body>
</html>
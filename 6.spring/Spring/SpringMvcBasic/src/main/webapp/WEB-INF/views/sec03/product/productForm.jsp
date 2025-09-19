<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>productForm</title>
    <style>
        body {
            padding-left: 4rem;
        }

        form {
            display: grid;
            grid-template-columns: 100px 200px;
            row-gap: 0.5rem;
            column-gap: 1rem;
            align-items: center;
        }
    </style>
  </head>
  <body>
    <h3>제품 정보 등록</h3>
    <form method="post" action="<c:url value='/sec03/product/newProduct' />">
      <label for="prdNo">상품번호</label>
      <input type="text" name="prdNo" id="prdNo">
      <label for="prdName">상품명</label>
      <input type="text" name="prdName" id="prdName">
      <label for="prdPrice">가격</label>
      <input type="text" name="prdPrice" id="prdPrice">
      <label for="prdCompany">제조회사</label>
      <input type="text" name="prdCompany" id="prdCompany">
      <label for="prdDate">제조일</label>
      <input type="text" name="prdDate" id="prdDate">
      <label for="prdStock">재고</label>
      <input type="text" name="prdStock" id="prdStock">
      <input type="submit" value="등록"> <input type="reset" value="취소">
    </form>
  </body>
</html>
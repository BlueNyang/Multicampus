<%@ page import="java.time.LocalDate"%>
<%@ page import="kr.bluenyang.practice.membercontrol.domain.member.MemberVO"%><%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <link rel="stylesheet" href="../style.css"/>
    <style>
        body {
            display: flex;
            flex-direction: column;
            width: fit-content;
            margin: 0 auto;
            position: relative;
        }

        form {
            margin: 0 auto;
            display: grid;
            width: 350px;
            gap: 10px;
            padding: 20px;
            border: 1px solid #ccc;
            grid-template-columns: 80px 1fr;
        }

        .cls1 {
            font-size: 40px;
            text-align: center;
        }

        .cls2 {
            display: inline-flex;
            justify-content: space-between;
        }

        .cls3 {
            font-size: 1rem;
        }
    </style>
  </head>
  <body>
    <p class="cls1">상품 등록</p>
    <div class="cls2">
      <a class="cls3" href="${contextPath}/product/productView.do">목록으로</a>
      <div></div>
    </div>
    <form name="frmMember" method="post" action="${contextPath}/product/productInsert.do">
      <label for="prdNo">상품 번호: </label>
      <input type="text" name="prdNo" id="prdNo">
      <label for="prdPrice">상품 이름: </label>
      <input type="text" name="prdName" id="prdName">
      <label for="prdName">상품 가격: </label>
      <input type="number" name="prdPrice" id="prdPrice">
      <label for="prdMaker">제조사: </label>
      <input type="text" name="prdMaker" id="prdMaker">
      <label for="prdColor">색상: </label>
      <input type="text" name="prdColor" id="prdColor">
      <label for="ctgNo">카테고리 번호: </label>
      <input type="number" name="ctgNo" id="ctgNo">
      <input type="hidden" name="joinDate" value="<%=LocalDate.now()%>">
      <input type="reset" value="초기화">
      <input type="submit" value="등록">
    </form>
  </body>
</html>

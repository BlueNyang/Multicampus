<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>홈페이지</title>
    <link rel="stylesheet" href="style.css"/>
    <style>
        #wrapper {
            display: flex;
            flex-direction: column;
            width: fit-content;
            margin: 0 auto;
            position: relative;
            text-align: center;
            align-items: center;
            justify-content: center;
        }

        #menu {
            display: inline-flex;
            width: 100%;
            margin-top: 20px;
            justify-content: space-around;
        }

        .mainImg {
            width: 200px;
            height: 200px;
        }
    </style>
  </head>
  <body>
    <div id="wrapper">
      <img src="./image/duke.png" alt="" class="mainImg"/><br>
      <h1>안녕하세요</h1>
      <h1>쇼핑몰 중심 JSP 홈페이지 입니다!!!</h1>
      <div id="menu">
        <a href="${pageContext.request.contextPath}/member/memberView.do">회원목록</a>
        <a href="${pageContext.request.contextPath}/product/productView.do">상품 목록</a>
      </div>
    </div>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 24/09/2025
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Index Page</title>
  </head>
  <body>
    <h2>
      MyBatis 사용 DB 연동
    </h2>
    <hr/>
    <a href="<c:url value="/product/listAllProduct"/>">상품 목록 보기</a>
    <br/>
    <a href="<c:url value="/book/listAllBook"/>">도서 목록 보기</a>
    <hr/>
  </body>
</html>

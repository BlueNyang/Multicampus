<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:set var="id" value="honggd"/>
<c:set var="pwd" value="1234"/>
<c:set var="name" value="홍길동"/>
<c:set var="email" value="hong@exmaple.com"/>
<html>
  <head>
    <meta charset="UTF-8">
    <title>c:set</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <span>${id}</span>
    <span>${pwd}</span>
    <span>${name}</span>
    <span>${email}</span>
  </body>
</html>

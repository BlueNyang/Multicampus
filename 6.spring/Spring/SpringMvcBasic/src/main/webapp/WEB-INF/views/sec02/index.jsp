<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 19/09/2025
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Sec02</title>
  </head>
  <body>
    <h2>Index Page 입니다.</h2>
    <a href="<c:url value='/sec02/showInfo'/>">sec02.2.showInfo</a>
    <a href="<c:url value='/sec02/showInfo2'/>">sec02.3.showInfo2</a>
    <a href="<c:url value='/sec02/showInfo3'/>">sec02.4.showInfo3</a>
    <a href="<c:url value='/sec02/bookInfoView1'/>">sec02.5.bookInfoView1</a>
    <a href="<c:url value='/sec02/bookInfoView2'/>">sec02.5.bookInfoView2</a>
    <hr/>
    <a href="<c:url value="/sec02/redirect"/>">sec02.6.redirect</a>
    <a href="<c:url value="/sec02/redirectParam1" />">sec02.7.redirectParam1</a>
    <a href="<c:url value="/sec02/redirectParam2" />">sec02.8.redirectParam2</a>
    <a href="<c:url value="/sec02/redirectParam3" />">sec02.9.redirectParam3</a>
  </body>
</html>

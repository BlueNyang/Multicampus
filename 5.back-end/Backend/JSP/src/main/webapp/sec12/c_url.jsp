<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>c:url</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <img src="/JSP/image/apple.png" alt="logo"/>
    <img src="../image/apple.png" alt="logo"/>
    <img src="${pageContext.request.contextPath}/image/apple.png" alt="logo"/>
    <img src="<c:url value='/image/apple.png'/>" alt="logo"/>


  </body>
</html>

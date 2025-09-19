<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 19/09/2025
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Student Result with getParameter</title>
  </head>
  <body>
    <h2>Student Result with getParameter</h2>
    <hr/>
    <h3>Student Info</h3>
    <p>Student No,: ${no}</p>
    <p>Student Name: ${name}</p>
    <p>Student Year: ${year}</p>
  </body>
</html>

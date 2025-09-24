<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 24/09/2025
  Time: 10:38
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
    <h2>Index.jsp 입니다</h2>
    <hr/>
    <a href="<c:url value="/sec01/"/>">Member View</a>
    <br/>
    <a href="<c:url value="/sec02/"/>">Product View</a>
    <hr/>
  </body>
</html>

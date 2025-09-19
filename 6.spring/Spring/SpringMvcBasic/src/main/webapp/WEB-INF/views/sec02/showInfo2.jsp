<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 19/09/2025
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>ShowInfo2</title>
  </head>
  <body>
    <h2>Show Info Page 입니다.</h2>
    <div>
      <p>name: ${name} </p>
      <p>addr: ${address} </p>
    </div>
  </body>
</html>

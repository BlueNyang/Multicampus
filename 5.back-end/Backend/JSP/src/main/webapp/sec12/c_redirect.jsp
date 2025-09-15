<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Redirect</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <c:redirect url="/sec12/urlTestRes.jsp">
      <c:param name="id" value="hong"/>
      <c:param name="pwd" value="1234"/>
      <c:param name="name" value="홍길동"/>
      <c:param name="email" value="hong@example.com"/>
    </c:redirect>

  </body>
</html>

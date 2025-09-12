<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 12/09/2025
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EL Binding Forward</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <%
      request.setAttribute("id", "hong");
      request.setAttribute("pwd", "1234");
      request.setAttribute("name", "홍길동");
      request.setAttribute("email", "hong@test.com");
    %>
    <jsp:forward page="el_binding_result.jsp"/>
  </body>
</html>

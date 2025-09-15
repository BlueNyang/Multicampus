<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Member Main</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <h2>Member Main</h2>
    <div style="display:flex; flex-direction:column; gap:10px;">
      <a href="${pageContext.request.contextPath}/exs/memberSelect">회원목록</a>
      <a href="${pageContext.request.contextPath}/ex/memberInsertForm.jsp">회원가입</a>
    </div>
  </body>
</html>

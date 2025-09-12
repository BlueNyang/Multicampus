<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 12/09/2025
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <a href="http://localhost:8080/Jsp01/el/login.jsp">로그인1</a><br>
    <!-- 현재 페이지를 요청할 때 서버의 주소는 브라우저에 저장됨 -->
    <a href="Jsp01/el/login.jsp">로그인2</a><br>
    <!-- 현재 페이지 요청 시 사용했던 contextPath 와 동일한 path사용-->
    <a href="<%=request.getContextPath()%>/login.jsp">로그인3</a><br>
    <a href="${pageContext.request.contextPath}/el/login.jsp">로그인4</a><br>
  </body>
</html>

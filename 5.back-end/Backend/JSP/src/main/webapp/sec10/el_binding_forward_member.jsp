<%@ page import="kr.bluenyang.practice.jsp.sec14.domain.MemberVO"%>
<%@ page import="java.time.LocalDate"%><%--
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
    <title>EL Member Object Binding Forward</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <%
      MemberVO mem = new MemberVO("honggd", "1234", "홍길동", "hong@example.com", null);
      request.setAttribute("mem", mem);
    %>
    <jsp:forward page="el_binding_result_member.jsp"/>
  </body>
</html>

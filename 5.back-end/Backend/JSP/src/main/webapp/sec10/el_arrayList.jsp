<%@ page import="kr.bluenyang.practice.jsp.sec14.domain.MemberVO"%><%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EL Array List</title>
    <link rel="stylesheet" href="../style.css"/>
    <%
      request.setCharacterEncoding("UTF-8");
    %>
  </head>
  <body>
    <jsp:useBean id="member" class="kr.bluenyang.practice.jsp.sec09.MemberBean"/>
    <jsp:useBean id="membersList" class="java.util.ArrayList"/>
    <%
      MemberVO mem1 = new MemberVO("honggd", "1234", "홍길동", "hong@example.com", null);
      MemberVO mem2 = new MemberVO("sonhm", "5678", "손흥민", "son@example.com", null);

      membersList.add(mem1);
      membersList.add(mem2);

      request.setAttribute("membersList", membersList);
    %>
    <jsp:forward page="el_arrayList_result.jsp"/>
  </body>
</html>

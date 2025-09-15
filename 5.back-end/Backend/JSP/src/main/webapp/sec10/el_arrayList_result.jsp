<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%><%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EL Array List</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <c:forEach var="member" items="${membersList}">
      <div style="display: grid; grid-template-columns: 80px 1fr; width:200px;">
        <span>아이디:</span> <span>${member.id}</span>
        <span>비밀번호:</span> <span>${member.pwd}</span>
        <span>이름:</span> <span>${member.name}</span>
        <span>이메일:</span> <span>${member.email}</span>
      </div>
      <hr/>
    </c:forEach>
  </body>
</html>

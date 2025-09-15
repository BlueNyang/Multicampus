<%@ page import="kr.bluenyang.practice.jsp.sec10.MemberVO"%>
<%@ page import="java.time.LocalDate"%><%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="member" value="${requestScope.member}"/>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Modify Info</title>
    <link rel="stylesheet" href="../style.css"/>
    <style>
        form {
            margin: 0 auto;
            display: grid;
            width: 300px;
            gap: 10px;
            padding: 20px;
            border: 1px solid #ccc;
            grid-template-columns: 80px 1fr;
        }
    </style>
  </head>
  <body>
    <form name="frmMember" method="post" action="${contextPath}/exs/memberUpdate">
      <label for="id">아이디: </label>
      <input type="text" name="id" id="id" value="${member.id()}">
      <label for="pwd">비밀번호: </label>
      <input type="password" name="pwd" id="pwd" value="${member.pwd()}">
      <label for="name">이름: </label>
      <input type="text" name="name" id="name" value="${member.name()}">
      <label for="email">이메일: </label>
      <input type="text" name="email" id="email" value="${member.email()}">
      <div></div>
      <input type="submit" value="수정">
    </form>
  </body>
</html>

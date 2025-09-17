<%@ page import="java.time.LocalDate"%>
<%@ page import="kr.bluenyang.practice.membercontrol.domain.member.MemberVO"%><%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Member Register</title>
    <link rel="stylesheet" href="../style.css"/>
    <style>
        body {
            display: flex;
            flex-direction: column;
            width: fit-content;
            margin: 0 auto;
            position: relative;
        }

        form {
            margin: 0 auto;
            display: grid;
            width: 350px;
            gap: 10px;
            padding: 20px;
            border: 1px solid #ccc;
            grid-template-columns: 80px 1fr;
        }

        .cls1 {
            font-size: 40px;
            text-align: center;
        }

        .cls2 {
            display: inline-flex;
            justify-content: space-between;
        }

        .cls3 {
            font-size: 1rem;
        }
    </style>
  </head>
  <body>
    <p class="cls1">회원 등록</p>
    <div class="cls2">
      <a class="cls3" href="${contextPath}/member/memberView.do">목록으로</a>
      <div></div>
    </div>
    <form name="frmMember" method="post" action="${contextPath}/member/memberInsert.do">
      <label for="id">아이디: </label>
      <input type="text" name="id" id="id">
      <label for="pwd">비밀번호: </label>
      <input type="password" name="pwd" id="pwd">
      <label for="name">이름: </label>
      <input type="text" name="name" id="name">
      <label for="email">이메일: </label>
      <input type="text" name="email" id="email">
      <input type="hidden" name="joinDate" value="<%=LocalDate.now()%>">
      <input type="reset" value="초기화">
      <input type="submit" value="가입">
    </form>
  </body>
</html>

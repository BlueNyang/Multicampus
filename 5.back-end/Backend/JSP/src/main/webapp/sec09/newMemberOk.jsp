<%@ page import="java.text.SimpleDateFormat"%>
<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Member Ok</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <%
      request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id="member" class="kr.bluenyang.practice.jsp.sec09.MemberBean">
      <jsp:setProperty name="member" property="*"/>
    </jsp:useBean>

    <span>아이디: </span>
    <jsp:getProperty name="member" property="id"/>
    <br>
    <span>비밀번호: </span>
    <jsp:getProperty name="member" property="pwd"/>
    <br>
    <span>이름: </span>
    <jsp:getProperty name="member" property="name"/>
    <br>
    <span>이메일: </span>
    <jsp:getProperty name="member" property="email"/>
    <br>
    <span>가입일: </span>
    <jsp:getProperty name="member" property="joinDate"/>
    <br>
  </body>
</html>
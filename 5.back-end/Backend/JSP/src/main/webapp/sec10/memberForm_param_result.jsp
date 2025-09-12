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
    ${member.id}
    <br>
    <span>비밀번호: </span>
    ${member.pwd}
    <br>
    <span>이름: </span>
    ${member.name}
    <br>
    <span>이메일: </span>
    ${member.email}
    <br>
    <span>가입일: </span>
    ${member.joinDate}
    <br>
  </body>
</html>
<%@ page import="java.time.LocalDate"%>
<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Member Form</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <form name="frmMember" method="post" action="newMemberOk.jsp">
      <label for="id">아이디: </label>
      <input type="text" name="id" id="id"><br>
      <label for="pwd">비밀번호: </label>
      <input type="password" name="pwd" id="pwd"><br>
      <label for="name">이름: </label>
      <input type="text" name="name" id="name"><br>
      <label for="email">이메일: </label>
      <input type="text" name="email" id="email"><br>
      <input type="hidden" name="joinDate" value="<%=LocalDate.now()%>">
      <input type="submit" value="확인">
    </form>
  </body>
</html>
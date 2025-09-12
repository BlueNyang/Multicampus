<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>param 액션 태그</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <form name="frmLogin" method="post" action="loginForwardResult.jsp">
      <label for="user_id">아이디 : </label>
      <input type="text" id="user_id" name="user_id"><br>
      <label for="user_pw">비밀번호 : </label>
      <input type="password" id="user_pw" name="user_pw"><br>
      <input type="submit" value="로그인">
      <input type="reset" value="취소">
    </form>
  </body>
</html>
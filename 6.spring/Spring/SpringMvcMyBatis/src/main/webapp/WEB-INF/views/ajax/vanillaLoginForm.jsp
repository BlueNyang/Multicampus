<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Insert title here</title>
  </head>
  <body>
    <form name="frmLogin" method="post" action="<c:url value="/ajax/login"/>">
      <label for="user_id">아이디 : </label><input type="text" id="user_id" name="user_id"/><br/>
      <label for="user_pw">비밀번호 :</label><input type="password" id="user_pw" name="user_pw"><br/>
      <input type="submit" value="로그인"/>
      <input type="reset" value="취소"/>
    </form>
  </body>
</html>

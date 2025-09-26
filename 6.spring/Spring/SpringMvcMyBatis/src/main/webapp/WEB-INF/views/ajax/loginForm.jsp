<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Ajax 연습 : 로그인폼</title>
    <script src="<c:url value="/resources/js/jquery-3.7.1.min.js"/>"></script>
    <script src="<c:url value="/resources/js/ajax/login.js"/>"></script>
  </head>
  <body>
    <!-- form을 통한 submit이 발생하면 새로운 페이지의 요청 의미 -->
    <form id="frmLogin" name="frmLogin">
      <label for="user_id">아이디 : </label><input type="text" id="user_id" name="user_id"/><br/>
      <label for="user_pw">비밀번호 :</label><input type="password" id="user_pw" name="user_pw"><br/>
      <input type="submit" value="로그인"/>
      <input type="reset" value="취소"/>
    </form>
    <br><br>
  </body>
</html>
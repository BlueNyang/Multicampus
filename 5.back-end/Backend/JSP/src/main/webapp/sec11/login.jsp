<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>로그인</title>
  </head>
  <body>
    <form name="frmLogin" method="post" action="loginOk.jsp">
      <label for="user_id">아이디 : </label>
      <input type="text" id="user_id" name="user_id"><br>
      <label for="user_pw">비밀번호 :</label>
      <input type="password" id="user_pw" name="user_pw"><br>
      <input type="submit" value="로그인">
      <input type="reset" value="취소">
    </form>
    <br><br>
    <a href="/JSP/sec11/memberForm.jsp">회원등록하기</a>
    <%--dynamic register context path--%>
    <a href="${pageContext.request.contextPath}/sec11/memberForm.jsp">회원등록하기</a>
    <%--dynamic register context path--%>
    <a href="${contextPath}/sec11/memberForm.jsp">회원등록하기</a>
  </body>
</html>
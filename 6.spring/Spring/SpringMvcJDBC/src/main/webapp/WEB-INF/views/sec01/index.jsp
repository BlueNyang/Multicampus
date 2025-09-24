<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>index 페이지</title>
  </head>
  <body>
    <div style="text-align:center;">
      <h3>Spring JDBC 연결 예제</h3><br>

      <a href="<c:url value="./member/memberSelect"/>">회원 조회</a><br>
    </div>
  </body>
</html>
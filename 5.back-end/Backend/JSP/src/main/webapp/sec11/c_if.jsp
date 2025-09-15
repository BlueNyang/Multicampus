<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 변수 선언 -->
<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="홍길동" scope="page"/>
<c:set var="age" value="${22}" scope="page"/>
<c:set var="height" value="${170}" scope="page"/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>JSTL - c:if</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <c:if test="${age >= 20}">
      <h2>성인입니다.</h2>
    </c:if>
    <c:if test="${age < 20}">
      <h2>미성년자입니다.</h2>
    </c:if>

    <c:if test="${height >= 180}">
      <h2>키가 큽니다.</h2>
    </c:if>
    <c:if test="${height < 180}">
      <h2>키가 작습니다.</h2>
    </c:if>

  </body>
</html>








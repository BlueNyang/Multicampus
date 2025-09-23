<%--@elvariable id="student" type="kr.bluenyang.practice.sec03.model.Student"--%>
<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 23/09/2025
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Student Result with getParameter</title>
  </head>
  <body>
    <h2>Student Result with getParameter</h2>
    <hr/>
    <h3>Student Info</h3>
    <p>@modelAttribute를 사용하여 객체명을 바꿀 수 있고, EL에서도 바뀐 객체명으로 사용</p>
    <p>Student No: ${student.no}</p>
    <p>Student Name: ${student.name}</p>
    <p>Student Year: ${student.year}</p>
    <p>Student Birth: ${student.birthDate}</p>

  </body>
</html>

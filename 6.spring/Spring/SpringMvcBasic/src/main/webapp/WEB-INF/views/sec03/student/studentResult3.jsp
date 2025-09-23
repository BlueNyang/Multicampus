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
    <p>Command Object를 활용해 View에 전달될 경우, 자동으로 model에 object로 저장하여 view로 전달되고, EL에서는 Object명.Field명 형태로 사용가능</p>
    <p>Student No: ${student.no}</p>
    <p>Student Name: ${student.name}</p>
    <p>Student Year: ${student.year}</p>
  </body>
</html>

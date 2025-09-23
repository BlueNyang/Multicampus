<%--@elvariable id="no" type="java.lang.String"--%>
<%--@elvariable id="name" type="java.lang.String"--%>
<%--@elvariable id="year" type="java.lang.String"--%>
<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 19/09/2025
  Time: 15:35
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
    <p>Student No: ${no}</p>
    <p>Student Name: ${name}</p>
    <p>Student Year: ${year}</p>

    <hr/>

    <br/>

    <h2>URL에 의한 데이터 전달</h2>
    <p>학번은 서버에게 전달되어해당 학번 학생의 정보를 확인</p>
    <p>http://localhost:8080/Spring/MvcBasic/sec03/student/studentDetailView/001</p>
    <span>학번: </span>
    <a href="<c:url value="/sec03/student/studentDetailView/${no}"/>">
      ${no}
    </a>
    <br/>
    <p>URL을 통한 데이터 여러 개 전달</p>
    <span>학번: </span>
    <a href="<c:url value="/sec03/student/studentDetailView/${no}/${name}/${year}"/>">
      ${no}
    </a>
  </body>

  </body>
</html>

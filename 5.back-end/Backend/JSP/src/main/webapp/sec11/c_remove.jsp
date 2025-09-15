<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   isELIgnored="false"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  request.setCharacterEncoding("UTF-8");
%>

<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'홍길동'}" scope="page"/>
<c:set var="age" value="${22}" scope="page"/>
<c:set var="height" value="${177}" scope="page"/>


<html>
  <head>
    <meta charset=”UTF-8">
    <title>회원 정보 출력 창</title>
    <link rel="stylesheet" href="../style.css"/>
    <style>
        table, tr {
            text-align: center;
        }

        th {
            background-color: lightgreen;
            width: 7%;
        }
    </style>
  </head>
  <body>
    <table>
      <tr>
        <td><b>아이디</b></td>
        <td><b>비밀번호</b></td>
        <td><b>이름</b></td>
        <td><b>나이</b></td>
        <td><b>키</b></td>
      </tr>
      <tr>
        <td>${id}</td>
        <td>${pwd}</td>
        <td>${name}</td>
        <td>${age}</td>
        <td>${height}</td>
      </tr>
    </table>
  </body>
</html>

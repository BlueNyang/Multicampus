<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<c:set var="id" value="${param.id}"/>
<c:set var="pwd" value="${param.pwd}"/>
<c:set var="name" value="${param.name}"/>
<c:set var="email" value="${param.email}"/>
<html>
  <head>
    <meta charset=”UTF-8">
    <title>회원 정보 출력창</title>
    <link rel="stylesheet" href="../style.css"/>
    <style>
        table,
        tr {
            text-align: center;
        }

        th {
            background-color: lightgreen;
        }
    </style>
  </head>
  <body>
    <table>
      <tr>
        <th><b>아이디</b></th>
        <th><b>비밀번호</b></th>
        <th><b>이름</b></th>
        <th><b>이메일</b></th>
      </tr>
      <tr>
        <td>${id}</td>
        <td>${pwd}</td>
        <td>${name}</td>
        <td>${email}</td>
      </tr>
    </table>

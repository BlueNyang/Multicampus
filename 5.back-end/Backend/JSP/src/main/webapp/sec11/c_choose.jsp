<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="id" value="hong2" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="홍길동" scope="page"/>
<c:set var="age" value="${20}" scope="page"/>
<c:set var="height" value="${170}" scope="page"/>
<c:set var="height1" value="180" scope="page"/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>JSTL - c:choose</title>
    <link rel="stylesheet" href="../style.css"/>
    <style>
        table,
        tr {
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
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>나이</th>
        <th>키</th>
      </tr>
      <c:choose>
        <c:when test="${name == null}">
          <tr>
            <td colspan="5">회원 이름을 찾을 수 없습니다.</td>
          </tr>
        </c:when>
        <c:when test="${empty age}">
          <tr>
            <td colspan="5">회원 나이를 찾을 수 없습니다.</td>
          </tr>
        </c:when>
        <c:when test="${height == ''}">
          <tr>
            <td colspan="5">회원 키를 찾을 수 없습니다.</td>
          </tr>
        </c:when>
        <c:otherwise>
          <tr>
            <td>${id}</td>
            <td>${pwd}</td>
            <td>${name}</td>
            <td>${age}</td>
            <td>${height}</td>
          </tr>
        </c:otherwise>
      </c:choose>
    </table>
  </body>
</html>






<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="memberList" value="${requestScope.memberList }" scope="page"/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>JSTL : c:forEach</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <table>
      <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
      </tr>
      <c:forEach var="member" items="${memberList}">
        <tr>
          <td>${member.id}</td>
          <td>${member.pwd}</td>
          <td>${member.name}</td>
          <td>${member.email}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
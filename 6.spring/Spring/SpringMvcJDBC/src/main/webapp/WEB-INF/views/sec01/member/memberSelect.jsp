<%--@elvariable id="memList" type="java.util.List"--%>
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
    <title>Insert title here</title>
    <style>
      thead tr {
        background-color: limegreen;
      }

      th {
        width: 7%;
      }
    </style>
  </head>
  <body>

    <table>
      <thead>
        <tr>
          <th>아이디</th>
          <th>비밀번호</th>
          <th>이름</th>
          <th>이메일</th>
          <th>가입일</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="mem" begin="0" end="${memList.size()}" step="1" items="${memList}">
          <tr>
            <td>${mem.memId }</td>
            <td>${mem.memPwd }</td>
            <td>${mem.memName }</td>
            <td>${mem.memEmail }</td>
            <td>${mem.memJoinDate }</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
<%--@elvariable id="studentList" type="java.util.List"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Student Search Result</title>
  </head>
  <body>
    <h1>학생 검색 결과</h1>
    <table>
      <tr>
        <th>학번</th>
        <th>이름</th>
        <th>학년</th>
      </tr>
      <c:forEach var="student" items="${studentList}">
        <tr>
          <td>${student.no}</td>
          <td>${student.name}</td>
          <td>${student.year}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>

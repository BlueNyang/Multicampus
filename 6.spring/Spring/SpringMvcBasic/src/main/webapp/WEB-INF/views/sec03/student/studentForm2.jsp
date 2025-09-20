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
    <title>Student Form</title>
  </head>
  <body>
    <h3>학생 정보 등록</h3>

    <form method="post" action="<c:url value='/sec03/student/newStudent2'/>">
      <!-- <form method="post" action="/project/student/newStudent"> -->
      학번 <input type="text" name="no"><br>
      성명 <input type="text" name="name"><br>
      학년 <input type="text" name="year"><br>
      <input type="submit" value="등록"> <input type="reset" value="취소">
    </form>
  </body>
</html>
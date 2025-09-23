<%@ page
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Student Form</title>
  </head>
  <body>
    <h3>학생 정보 등록</h3>

    <form method="post" action="<c:url value='/sec03/student/newStudent5'/>">
      <!-- <form method="post" action="/project/student/newStudent"> -->
      <label for="no">학번</label>
      <input type="text" name="no" id="no"><br>
      <label for="name">성명</label>
      <input type="text" name="name" id="name"><br>
      <label for="year">학년</label>
      <input type="text" name="year" id="year"><br>
      <label for="birthDate">생년월일</label>
      <input type="date" name="birthDate" id="birthDate"><br>
      <br>
      <input type="submit" value="등록">
      <input type="reset" value="취소">
    </form>
  </body>
</html>
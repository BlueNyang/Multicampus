<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>학생 검색</title>
  </head>
  <body>
    <h3>학생 검색</h3>
    <form method="post" action="<c:url value='/sec03/student/studentSearch'/>">
      <label for="type"></label>
      <select id="type" name="type">
        <option value="">검색 조건 선택</option>
        <option value="no">학번</option>
        <option value="name">성명</option>
      </select>

      <label for="keyword"></label>
      <input type="text" name="keyword" id="keyword">
      <input type="submit" value="검색">
    </form>
  </body>
</html>
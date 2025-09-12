<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <form name="frmMultiply" method="post" action="forResult.jsp">
      <label for="dan">구구단 단 입력:</label>
      <input type="text" name="dan" id="dan">
      <input type="submit" name="result" value="확인">
    </form>
  </body>
</html>
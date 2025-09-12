<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <title>response 객체</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <form method="post" action="responseOk.jsp">
      <label for="answer">대한민국의 수도는 ?</label>
      <input type="text" name="answer" size="10" id="answer">
      <input type="submit" value="전송">
    </form>
  </body>
</html>
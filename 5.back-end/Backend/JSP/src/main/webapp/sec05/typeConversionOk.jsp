<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Type Conversion</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <%!
      int width;
      int height;
    %>
    <%
      width = Integer.parseInt(request.getParameter("width"));
      height = Integer.parseInt(request.getParameter("height"));
    %>
    사각형 넓이 : <%=width * height%>
  </body>
</html>
<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ page import="java.util.*"%>
<%
  Date date = new Date();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>include 지시어 : top</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <h3 style="color: blue; font-size: 20pt;">top.jsp 입니다</h3>
    현재 시간은 <b><%=date.toString()%>
  </b> 입니다
  </body>
</html>
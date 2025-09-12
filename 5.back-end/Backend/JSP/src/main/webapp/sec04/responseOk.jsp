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
    <%--	request 객체에 저장되어 전달되는 answer 값에 따라 두 페이지 중 하나로 포워딩	--%>
    <%! String answer; %>
    <%
      request.setCharacterEncoding("UTF-8");
      answer = request.getParameter("answer");

      if ("서울".equals(answer)) {
        response.sendRedirect("pass.jsp");
      } else {
        response.sendRedirect("fail.jsp");
      }
    %>
  </body>
</html>
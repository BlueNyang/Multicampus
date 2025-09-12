<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>forward 액션 태그</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <%!
      String msg = "";
    %>
    <%
      request.setCharacterEncoding("UTF-8");
      String user_id = request.getParameter("user_id");

      if (user_id == null || user_id.isEmpty()) {
        msg = "아이디를 입력하세요";
    %>
    <jsp:forward page="login_param.jsp">
      <jsp:param name="msg" value="<%=msg%>"/>
    </jsp:forward>
    <%
      }
    %>
    <h3>환영합니다 <%=user_id%> 님</h3>
  </body>
</html>
<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>request 연습문제 요청 처리</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <%!
      String id;
      String name;
      String pw;
      String phone;
      String grade;
      String department;
      String[] interests;
    %>

    <%
      request.setCharacterEncoding("UTF-8");
      id = request.getParameter("id");
      name = request.getParameter("name");
      pw = request.getParameter("pw");
      phone = request.getParameter("hp1")
         + "-" + request.getParameter("hp2")
         + "-" + request.getParameter("hp3");
      grade = request.getParameter("grade");
      department = request.getParameter("department");
      interests = request.getParameterValues("interests");
      if (interests == null) {
        interests = new String[]{"선택사항 없음"};
      }
    %>

    <span>이름 : <%=name%></span><br/>
    <span>아이디 : <%=id%> </span><br/>
    <span>비밀번호 : <%=pw%></span><br/>
    <span>전화번호 : <%=phone%></span><br/>
    <span>학년 : <%=grade%></span><br/>
    <span>관심있는 분야 : </span>
    <ul style="padding: 0 20px; margin:0;">
      <% for (String interest : interests) { %>
      <li><%=interest%>
      </li>
      <% } %>
    </ul>
    <span>학과 : <%=department%> </span><br/>

  </body>
</html>
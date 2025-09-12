<%@ page import="java.util.Arrays"%>
<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>폼에 입력된 값으로 빈 속성값 한꺼번에 설정</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <%
      request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id="student" class="kr.bluenyang.practice.jsp.sec09.StudentBean">
      <jsp:setProperty property="*" name="student"/>
    </jsp:useBean>

    <h3> Bean 속성값 출력</h3>
    <span>학번: </span> <%=student.getStdNo()%><br>
    <span>성명: </span> <%=student.getStdName()%><br>
    <span>전화: </span> <%=student.getStdPhone()%><br>
    <span>주소: </span> <%=student.getStdAddr()%><br>
    <span>학년: </span> <%=student.getStdYear()%><br>
    <span>관심분야: </span> <%=Arrays.toString(student.getStdInterests())%><br>
  </body>
</html>
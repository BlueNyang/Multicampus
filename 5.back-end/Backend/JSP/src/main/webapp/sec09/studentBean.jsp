<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<jsp:useBean id="student" class="kr.bluenyang.practice.jsp.sec09.StudentBean" scope="page"/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>자바빈</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <h3>Bean 속성값 설정 (setProperty 사용)</h3>
    <jsp:setProperty name="student" property="stdNo" value="20250001"/>
    <jsp:setProperty name="student" property="stdName" value="홍길동"/>
    <jsp:setProperty name="student" property="stdPhone" value="010-1234-5678"/>
    <jsp:setProperty name="student" property="stdAddr" value="서울"/>
    <jsp:setProperty name="student" property="stdYear" value="3"/>

    <h3>Bean 속성값 출력 (getProperty 사용)</h3>
    <span>학번: </span>
    <jsp:getProperty name="student" property="stdNo"/>
    <br>
    <span>성명: </span>
    <jsp:getProperty name="student" property="stdName"/>
    <br>
    <span>전화: </span>
    <jsp:getProperty name="student" property="stdPhone"/>
    <br>
    <span>주소: </span>
    <jsp:getProperty name="student" property="stdAddr"/>
    <br>
    <span>학년: </span>
    <jsp:getProperty name="student" property="stdYear"/>
    <br>

    <h3>Bean 속성값 출력 (Getter 사용)</h3>
    <span>학번: </span> <%=student.getStdNo()%><br>
    <span>성명: </span> <%=student.getStdName()%><br>
    <span>전화: </span> <%=student.getStdPhone()%><br>
    <span>주소: </span> <%=student.getStdAddr()%><br>
    <span>학년: </span> <%=student.getStdYear()%><br>

  </body>
</html>







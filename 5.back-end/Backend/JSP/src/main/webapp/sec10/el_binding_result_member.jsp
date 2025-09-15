<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 12/09/2025
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EL Member Object Binding Forward</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <span>request 객체에 attribute로 바인딩된 data el로 출력</span><br>
    <span>아이디: ${mem.id}</span><br>
    <span>비밀번호: ${mem.pwd}</span><br>
    <span>이름: ${mem.name}</span><br>
    <span>이메일: ${mem.email}</span><br>

    <h3>태그의 속성 값으로 ㅍ표현 언어 사용</h3>
    <form method="post" action="memberEdit.jsp">
      <div style="display:grid; grid-template-columns: 80px 1fr; width:200px;">
        <label for="id">아이디: </label><input id="id" type="text" name="id" value="${mem.id}"/>
        <label for="pwd">비밀번호: </label><input id="pwd" type="password" name="pwd" value="${mem.pwd}"/>
        <label for="name">이름: </label><input id="name" type="text" name="name" value="${mem.name}"/>
        <label for="email">이메일: </label><input id="email" type="email" name="email" value="${mem.email}"/>
      </div>
    </form>
  </body>
</html>
  
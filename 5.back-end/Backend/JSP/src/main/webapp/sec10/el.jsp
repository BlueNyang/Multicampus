<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 12/09/2025
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EL</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <span>plain text: 100</span><br/>
    <span>Expression: <%=100%></span><br/>
    <span>ExLang: ${100}</span><br/>
    <span>ExLang: ${"String"}</span><br/>
    <span>ExLang: ${true}</span><br/>
    <span>ExLang: ${true && true}</span><br/>
    <span>ExLang: ${100 - 90}</span><br/>
    <span>ExLang: ${100 % 90}</span><br/>
    <span>ExLang: ${100 mod 90}</span><br/>
    <%--<span>ExLang: ${"hello" + " world}</span><br/>--%>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 19/09/2025
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Index JSP</title>
    <style>
      body {
        display: flex;
        flex-direction: column;
        padding-left: 4rem;
        width: 80%;
      }

      hr {
        width: 80%;
        margin: 1rem 0;
      }
    </style>
  </head>
  <body>
    <h2>Index.jsp 입니다</h2>
    <hr/>
    <a href="/SpringMvcJDBC">SpringMvcJDBC</a>
    <hr/>
    <a href="/SpringMvcMyBatis">SpringMvcMyBatis</a>
    <hr/>
    <a href="<c:url value='/sec01/home'/>">sec01.1.jsp/home</a>
    <a href="<c:url value='/sec01/newView'/>">sec01.2.newView</a>
    <hr/>
    <a href="<c:url value='/sec02/home'/>">sec02.Request Param & Model</a>
    <hr/>
    <a href="<c:url value='/sec03/home'/>">sec03.Request Model</a>
  </body>
</html>

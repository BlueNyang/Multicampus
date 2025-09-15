<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%><%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  List<String> dataList = new ArrayList<>();

  dataList.add("hello");
  dataList.add("world");
  dataList.add("java");

  request.setAttribute("dataList", dataList);
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>ForEach</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <c:forEach var="data" items="${dataList }">
      <span>${data}</span>
      <br/>
    </c:forEach>

    <c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
      <span>
        i=${i}, iter: ${loop.count}, index:${loop.index}, ${loop.first?'first':''}${loop.last?'last':''}
      </span>
      <br/>
    </c:forEach>

  </body>
</html>

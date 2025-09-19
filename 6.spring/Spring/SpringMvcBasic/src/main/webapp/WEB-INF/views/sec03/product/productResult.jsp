<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 19/09/2025
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>"/>
    <title>ProductResult</title>
  </head>
  <body>
    <h2>Product Result</h2>
    <hr/>
    <h3>Product Info</h3>
    <p>Product No: ${prdNo}</p>
    <p>Product Name: ${prdName}</p>
    <p>Product Price: ${prdPrice}</p>
    <p>Product Company: ${prdCompany}</p>
    <p>Product Date: ${prdDate}</p>
    <p>Product Stock: ${prdStock}</p>
  </body>
</html>

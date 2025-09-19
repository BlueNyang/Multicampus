<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 19/09/2025
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Request Parameter</title>
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
    <h3>Sec03</h3>
    <a href="<c:url value='/sec03/student/studentForm'/>">sec03.1.1studentForm(getParameter)</a>
    <a href="<c:url value='/sec03/student/studentForm2'/>">sec03.1.2studentForm2(@RequestParam)</a>
    <hr/>
    <a href="<c:url value="/sec03/product/productForm"/>">sec03.2.1.productForm</a>
  </body>
</html>

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
    <a href="<c:url value='/sec03/student/studentForm'/>">sec03.1.1.studentForm(getParameter)</a>
    <a href="<c:url value='/sec03/student/studentForm2'/>">sec03.1.2.studentForm2(@RequestParam)</a>
    <a href="<c:url value='/sec03/student/studentForm3'/>">sec03.1.3.studentForm3(Command Object)</a>
    <a href="<c:url value='/sec03/student/studentForm4'/>">sec03.1.4.studentForm4(@ModelAttribute)</a>
    <a href="<c:url value='/sec03/student/studentForm5'/>">sec03.1.5.studentForm5(@DateTimeFormat)</a>
    <a href="<c:url value='/sec03/student/studentSearchForm'/>">sec03.1.5.studentSearch</a>
    <hr/>
    <a href="<c:url value="/sec03/product/productForm"/>">sec03.2.1.productForm(getParameter)</a>
    <a href="<c:url value="/sec03/product/productForm2"/>">sec03.2.2.productForm(@RequestParam)</a>
    <a href="<c:url value="/sec03/product/productForm3"/>">sec03.2.3.productForm(Command Object)</a>
    <a href="<c:url value="/sec03/product/productForm4"/>">sec03.2.4.productForm(@ModelAttribute)</a>
    <a href="<c:url value="/sec03/product/productSearchForm"/>">sec03.2.5.productSearch</a>
    <hr/>
  </body>
</html>

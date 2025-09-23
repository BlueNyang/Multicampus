<%--@elvariable id="nation" type="java.lang.String"--%>
<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 23/09/2025
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Show Redirect Param</title>
  </head>
  <body>
    <p>Nation: ${nation}</p>
  </body>
</html>

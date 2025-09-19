<%@ page contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
  </head>
  <body>
    <h1>
      Hello world!
    </h1>

    <a href="<c:url value="/newView"/>"></a>
    <img src="<c:url value="/resources/image/apple.png"/>" alt="apple"/>
  </body>
</html>
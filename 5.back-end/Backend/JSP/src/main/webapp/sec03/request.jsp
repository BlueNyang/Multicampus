<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>request 객체</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <h1>request 객체</h1>
    <span>
  Method <%=request.getMethod()%>
</span>
    <br/>
    <span>
  Protocol <%=request.getProtocol()%>
</span>
    <br/>
    <span>
  ReqURL <%=request.getRequestURL()%>
</span>
    <br/>
    <span>
  ReqURI <%=request.getRequestURI()%>
</span>
    <br/>
    <span>
  ContextPath <%=request.getContextPath()%>
</span>
    <br/>
    <span>
  ServletPath <%=request.getServletPath()%>
</span>
  </body>
</html>
<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>변수</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <%!
      int x = 10;
      float f = 3.14159f;

      public int plus(int x) {
        return x + 10;
      }
    %>

    <%
      // Cannot define a method in scriptlet - it must be in declaration block
      //  public int minux(int x) {
      //      return x - 10;
      //  }
    %>

    <h3>변수의 값 출력</h3>
    <p>
      x : <%=x %>
    </p>
    <p>
      y : <%=plus(x) %>
    </p>
    <p>
      x+y : <%=x + plus(x) %>
    </p>
    <p>
      floatValue : <%=f %>
    </p>
    <p>
      doubleValue : <%=f * 2 %>
    </p>
    <p>
      c : <%= 'A' %>
    </p>
    <p>
      job : <%= "programmer" %>
    </p>
    <p>
      b : <%= true %>
    </p>

  </body>
</html>
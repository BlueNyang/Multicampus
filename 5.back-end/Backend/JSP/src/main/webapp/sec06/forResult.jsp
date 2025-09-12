<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <%!
      int dan;
    %>
    <%
      try {
        dan = Integer.parseInt(request.getParameter("dan"));
      } catch (NumberFormatException e) {
        dan = 0;
      }
    %>
    <% if (dan < 2 || dan > 9) { %>
    <script>
      alert("2~9 사이의 값을 입력하세요");
      history.back();
    </script>
    <% } %>

    <h3><%=dan%>단</h3>
    <table>
      <%
        for (int i = 1; i <= 9; i++) {
      %>
      <tr>
        <td>
          <%=dan%> * <%=i%> = <%=dan * i %>
        </td>
      </tr>
      <%
        }
      %>
    </table>
  </body>
</html>
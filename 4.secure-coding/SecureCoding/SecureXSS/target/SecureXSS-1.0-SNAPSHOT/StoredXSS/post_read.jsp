<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@ page import="io.github.cdimascio.dotenv.Dotenv" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시글 상세 열람</title>
    <link rel="stylesheet" href="../style.css">
    <style>
        h1,
        table {
            width: 70%;
            margin: 0 auto;
        }

        h1 {
            text-align: center;
        }

        table, th, td {
            border: 1px solid black;
        }

        th,
        td {
            padding: 5px 10px;
            text-align: left;
        }

        .content {
            height: 300px;
            vertical-align: top;
        }
    </style>
</head>

<body>
<h1>게시글 상세 열람</h1>
<%
    Dotenv dotenv = Dotenv.load();
    String dbURL = dotenv.get("DB_URL");
    String dbUser = dotenv.get("DB_USERNAME");
    String dbPassword = dotenv.get("DB_PASSWORD");
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet result = null;
    String sql = null;
    try {
        Class.forName(dotenv.get("DB_DRIVER"));
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

        int num = Integer.parseInt(request.getParameter("num"));

        sql = "SELECT * FROM PRACTICE_BOARD WHERE num = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, num);

        result = pstmt.executeQuery();
%>

<table border="1">
    <% while (result.next()) {%>
    <tr>
        <td>번호</td>
        <td>
            <%=result.getInt("num")%>
        </td>
    </tr>
    <tr>
        <td>작성일</td>
        <td>
            <%=result.getTimestamp("regdate")%>
        </td>
    </tr>
    <tr>
        <td>작성자</td>
        <td>
            <%=result.getString("writer")%>
        </td>
    </tr>
    <tr>
        <td>제목</td>
        <td>
            <%=result.getString("title")%>
        </td>
    </tr>
    <tr class="content">
        <td>내용</td>
        <td>
            <%=result.getString("content")%>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <button type=button onclick="location.href='post_list.jsp'">목록으로</button>
        </td>
    </tr>
    <% }%>
</table>
<% } catch (Exception ex) {
    out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}%>

</body>
</html>
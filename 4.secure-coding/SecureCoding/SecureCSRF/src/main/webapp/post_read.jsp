<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@ page import="io.github.cdimascio.dotenv.Dotenv" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세 열람</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <style>
        table,
        th,
        td {
            border: 1px solid black;
        }

        th,
        td {
            padding: 4px 8px;
        }
    </style>
</head>
<body>
<h1>게시글 상세 열람</h1>
<%
    String s_id = (String) session.getAttribute("sessionID");
    String s_name = (String) session.getAttribute("sessionName");
    System.out.println("[DEBUG] post_read.jsp: sessionID = " + s_id + ", sessionName = " + s_name);

    if (s_id != null) {
        try {
            Dotenv dotenv = Dotenv.load();

            String dbURL = dotenv.get("DB_URL");
            String dbUser = dotenv.get("DB_USERNAME");
            String dbPassword = dotenv.get("DB_PASSWORD");
            String dbDriver = dotenv.get("DB_DRIVER");

            Class.forName(dbDriver);
            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            request.setCharacterEncoding("UTF-8");

            String num = request.getParameter("num");

            String insertQuery = "SELECT * FROM practice_board WHERE num=" + num;

            PreparedStatement psmt = connection.prepareStatement(insertQuery);

            ResultSet result = psmt.executeQuery();
            result.next();
            String name = result.getString("writer");
%>

<table>

    <tr>
        <td>번호</td>
        <td><%=result.getInt("num") %>
        </td>
    </tr>
    <tr>
        <td>작성일</td>
        <td><%=result.getTimestamp("regdate") %>
        </td>
    </tr>
    <tr>
        <td>작성자</td>
        <td><%=name %>
        </td>
    </tr>
    <tr>
        <td>제목</td>
        <td><%=result.getString("title") %>
        </td>
    </tr>
    <tr>
        <td>내용</td>
        <td><%=result.getString("content") %>
        </td>
    </tr>
    <tr>
        <td>
            <button type=button onclick="location.href='/csrf/post_list.jsp'">목록으로</button>
        </td>
        <td>
            <%
                if (s_name.equals(result.getString("writer"))) { %>
            <button type="button" value="수정"
                    onClick="location.href='post_modify.jsp?num=<%=result.getString("num") %>'">수정
            </button>
            <button type="button" value="삭제"
                    onClick="location.href='post_delete_send.jsp?num=<%=result.getString("num") %>'">삭제
            </button>
            <%
                }
            %>
        </td>
    </tr>

</table>
<%
        } catch (Exception ex) {
            out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
        }
    } else {
        response.sendRedirect("/");
    }%>

</body>
</html>
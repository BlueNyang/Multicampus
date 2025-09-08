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
    <title>글 수정</title>
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

        input,
        textarea {
            border: none;
        }

        input:focus,
        textarea:focus {
            outline: none;
        }
    </style>
</head>
<body>
<h1>글 수정</h1>
<%

    String s_id = (String) session.getAttribute("sessionID");
    String s_name = (String) session.getAttribute("sessionName");
    String csrfToken = (String) session.getAttribute("csrfToken"); // CSRF Token 추출
    System.out.println("[DEBUG] post_modify.jsp: sessionID = " + s_id + ", sessionName = " + s_name + ", csrfToken = " + csrfToken);

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

            while (result.next()) {%>
<form action="post_modify_send.jsp" method="post">
    <input type="hidden" name="num" value="<%=result.getInt("num") %>">
    <table>
        <tr>
            <td>작성자</td>
            <td>
                <label>
                    <input type="text" name="writer" value="<%=result.getString("writer") %>" readonly>
                </label>
            </td>
        </tr>
        <tr>
            <td>제목</td>
            <td>
                <label>
                    <input type="text" name="title" value="<%=result.getString("title") %>">
                </label>
            </td>
        </tr>
        <tr>
            <td>내용</td>
            <td>
                <label>
                    <textarea rows="10" cols="20" name="content"
                    ><%=result.getString("content") %></textarea>
                </label>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">수정</button>
                <button type="button" onclick="location.href='post_list.jsp'">목록으로</button>
                <button type="reset">원상복구</button>
            </td>
        </tr>
    </table>
    <%-- CSRF Token을 히든 필드로 삽입 --%>
    <input type="hidden" name="csrfToken" value="<%=csrfToken %>">
</form>
<%
            }
        } catch (Exception ex) {
            out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
        }
    } else {
        response.sendRedirect("/csrf");
    }
%>
</body>
</html>
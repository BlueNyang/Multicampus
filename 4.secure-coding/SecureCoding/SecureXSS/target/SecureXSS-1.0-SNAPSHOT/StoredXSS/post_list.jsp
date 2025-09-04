<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="io.github.cdimascio.dotenv.Dotenv" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
    <link rel="stylesheet" href="../style.css">
    <style>
        form {
            width: 70%;
            margin: auto;
            align-content: center;
            justify-content: center;
            text-align: center;
        }

        table {
            width: 100%;
        }

        table, th, td {
            border: 1px solid black;
        }

        th,
        td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .center {
            text-align: center;
        }

        .left {
            text-align: left;
        }

        .right {
            justify-content: end;
            text-align: right;
        }

        .number {
            width: 10px;
        }

        .writer {
            width: 50px;
        }

        .date {
            max-width: 100px;
        }

        .manage {
            width: 100px;
        }
    </style>
</head>

<body>
<form action="post_read.jsp" method="get">
    <h1>게시글 목록</h1>
    <%
        Dotenv dotenv = Dotenv.load();
        String dbURL = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbDriver = dotenv.get("DB_DRIVER");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String sql = null;
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            sql = "SELECT * FROM PRACTICE_BOARD ORDER BY num ASC";
            pstmt = conn.prepareStatement(sql);
            result = pstmt.executeQuery();
    %>

    <table>
        <tr>
            <td colspan="5">
                <h3>게시글 제목 클릭시 상세 열람 가능</h3>
            </td>
        </tr>
        <tr>
            <td colspan="5" class="right">
                <button type="button" value="신규 글 작성" onClick="location.href='post_new.jsp'">신규 글
                    작성
                </button>
            </td>
        </tr>
        <tr>
            <td class="number center">번호</td>
            <td class="writer center">작성자</td>
            <td class="left">제목</td>
            <td class="date center">작성일</td>
            <td class="manage center">관리</td>
        </tr>
        <%while (result.next()) {%>
        <tr>
            <td class="number center">
                <%=result.getInt("num")%>
            </td>
            <td class="writer center">
                <%=result.getString("writer")%>
            </td>
            <td class="left"><a href="post_read.jsp?num=<%=result.getInt("num")%>">
                <%=result.getString("title") %>
            </a></td>
            <td class="date center">
                <%=result.getTimestamp("regdate") %>
            </td>
            <td class="manage center">
                <button type="button" value="수정"
                        onClick="location.href='post_modify.jsp?num=<%=result.getString("num") %>'">수정
                </button>
                <button type="button" value="삭제"
                        onClick="location.href='post_delete_send.jsp?num=<%=result.getString("num") %>'">삭제
                </button>
            </td>
        </tr>
        <% }%>
    </table>
    <% } catch (Exception ex) {
        out.println("Error: " + ex.getMessage());
    }%>
</form>
</body>
</html>
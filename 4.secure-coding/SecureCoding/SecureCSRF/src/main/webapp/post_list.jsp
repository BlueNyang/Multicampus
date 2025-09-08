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
    <title>게시글 목록</title>
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
<form action="post_read.jsp" method="get">
    <h1>게시글 목록</h1>
    <%
        Cookie cookie = new Cookie("SESSIONID", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        // 로그인 증명 후 session 값 조회
        String s_id = (String) session.getAttribute("sessionID");
        String s_name = (String) session.getAttribute("sessionName");
        System.out.println("[DEBUG] post_list.jsp: sessionID = " + s_id + ", sessionName = " + s_name);
        if (s_id != null) {
            try {
                Dotenv dotenv = Dotenv.load();

                String dbURL = dotenv.get("DB_URL");
                String dbUser = dotenv.get("DB_USERNAME");
                String dbPassword = dotenv.get("DB_PASSWORD");
                String dbDriver = dotenv.get("DB_DRIVER");

                Class.forName(dbDriver);
                Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);

                String insertQuery = "SELECT * FROM practice_board order by num desc";
                PreparedStatement psmt = connection.prepareStatement(insertQuery);
                ResultSet result = psmt.executeQuery();
    %>

    <table>
        <tr>
            <td colspan="5">
                <h3>게시글 제목 클릭시 상세 열람 가능</h3>
            </td>
        </tr>
        <tr>
            <td colspan="5">
                <span><b><%=s_name %></b>님 환영합니다.</span>
                <button type="button" value="신규 글 작성" onClick="location.href='post_new.jsp'">신규 글 작성</button>
                <button type="button" value="로그아웃" onClick="location.href='logout.jsp'">로그아웃</button>
            </td>
        </tr>
        <tr>
            <td>번호</td>
            <td>작성자</td>
            <td>제목</td>
            <td>작성일</td>
            <td>비고</td>
        </tr>
        <%
            while (result.next()) {
        %>
        <tr>
            <td><%=result.getInt("num") %>
            </td>
            <td><%=result.getString("writer") %>
            </td>
            <td>
                <a href="post_read.jsp?num=<%=result.getInt("num") %>">
                    <%=result.getString("title") %>
                </a>
            </td>
            <td><%=result.getTimestamp("regdate") %>
            </td>
            <td>
                <%
                    if (s_name.equals(result.getString("writer"))) {
                %>
                <button type="button" value="수정"
                        onClick="location.href='/csrf/post_modify.jsp?num=<%=result.getInt("num") %>'">
                    수정
                </button>
                <button type="button" value="삭제"
                        onClick="location.href='/csrf/post_delete_send.jsp?num=<%=result.getInt("num") %>'">삭제
                </button>
                <%
                    }
                %>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <%
            } catch (Exception ex) {
                out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
            }

        } else {
            response.sendRedirect("/csrf/main.html"); //세션이 없으면 메인페이지로 이동
        }
    %>
</form>
</body>
</html>
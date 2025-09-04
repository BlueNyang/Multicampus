<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@ page import="io.github.cdimascio.dotenv.Dotenv" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    try {
        Dotenv dotenv = Dotenv.load();

        String dbURL = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbDriver = dotenv.get("DB_DRIVER");

        Class.forName(dbDriver);
        Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);

        request.setCharacterEncoding("UTF-8");

        String writer = request.getParameter("writer");
        writer = writer.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;").replaceAll("'", "&#x27;").replaceAll("/", "&#x2F;");
        String title = request.getParameter("title");
        title = title.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;").replaceAll("'", "&#x27;").replaceAll("/", "&#x2F;");
        String content = request.getParameter("content");
        content = content.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;").replaceAll("'", "&#x27;").replaceAll("/", "&#x2F;");

        String num = request.getParameter("num");

        String insertQuery = "SELECT * FROM PRACTICE_BOARD WHERE num=" + num;

        PreparedStatement psmt = connection.prepareStatement(insertQuery);
        ResultSet result = psmt.executeQuery();

        while (result.next()) {
            insertQuery = "UPDATE PRACTICE_BOARD set title=?, writer=?, content=? WHERE num=" + num;

            psmt = connection.prepareStatement(insertQuery);

            psmt.setString(1, title);
            psmt.setString(2, writer);
            psmt.setString(3, content);

            psmt.executeUpdate();

            response.sendRedirect("post_list.jsp");
        }
    } catch (Exception ex) {
        out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
    }
%>
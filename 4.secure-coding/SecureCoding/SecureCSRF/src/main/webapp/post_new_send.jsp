<%@page import="java.sql.Timestamp" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page import="io.github.cdimascio.dotenv.Dotenv" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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

        Timestamp today_date = new Timestamp(System.currentTimeMillis());

        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        int num = 0;

        String insertQuery = "SELECT MAX(num) from practice_board";

        PreparedStatement psmt = connection.prepareStatement(insertQuery);

        ResultSet result = psmt.executeQuery();

        while (result.next()) {
            num = result.getInt("MAX(num)") + 1;
        }

        insertQuery = "INSERT INTO practice_board(num, title, writer, content, regdate) VALUES (?, ?, ?, ?, ?)";

        psmt = connection.prepareStatement(insertQuery);

        psmt.setInt(1, num);
        psmt.setString(2, title);
        psmt.setString(3, writer);
        psmt.setString(4, content);
        psmt.setTimestamp(5, today_date);

        psmt.executeUpdate();

        response.sendRedirect("/csrf/post_list.jsp");
    } catch (Exception ex) {
        out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
    }
%>
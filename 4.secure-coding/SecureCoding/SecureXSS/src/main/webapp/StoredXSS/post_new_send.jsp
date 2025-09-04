<%@page import="java.sql.Timestamp" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page import="io.github.cdimascio.dotenv.Dotenv" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% try {
    Dotenv dotenv = Dotenv.load();
    String dbURL = dotenv.get("DB_URL");
    String dbUser = dotenv.get("DB_USERNAME");
    String dbPassword = dotenv.get("DB_PASSWORD");

    Class.forName(dotenv.get("DB_DRIVER"));
    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

    String insertQuery = "SELECT MAX(num) AS MAX_NUM FROM PRACTICE_BOARD";
    PreparedStatement pstmt = conn.prepareStatement(insertQuery);
    ResultSet result = pstmt.executeQuery();

    int num = 0;

    if (result.next()) {
        num = result.getInt("max_num") + 1;
    }

    Timestamp today_date = new Timestamp(System.currentTimeMillis());

    request.setCharacterEncoding("UTF-8");

    String title = request.getParameter("title");
    title = title.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
            .replaceAll("\"", "&quot;").replaceAll("'", "&#x27;").replaceAll("/", "&#x2F;");
    String writer = request.getParameter("writer");
    writer = writer.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
            .replaceAll("\"", "&quot;").replaceAll("'", "&#x27;").replaceAll("/", "&#x2F;");
    String content = request.getParameter("content");
    content = content.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
            .replaceAll("\"", "&quot;").replaceAll("'", "&#x27;").replaceAll("/", "&#x2F;");

    insertQuery = "INSERT INTO PRACTICE_BOARD (num, writer, title, content, regdate)  VALUES (?, ?, ?, ?, ?)";

    pstmt = conn.prepareStatement(insertQuery);
    pstmt.setInt(1, num);
    pstmt.setString(2, writer);
    pstmt.setString(3, title);
    pstmt.setString(4, content);
    pstmt.setTimestamp(5, today_date);

    pstmt.executeUpdate();

    response.sendRedirect("post_list.jsp");
} catch (Exception ex) {
    out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@ page import="io.github.cdimascio.dotenv.Dotenv" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    final String s_id = (String) session.getAttribute("sessionID");
    final String s_name = (String) session.getAttribute("sessionName");
    final String csrf_token = (String) session.getAttribute("csrfToken");

    // login이 안된 경우
    if (csrf_token == null) {
        response.sendRedirect("/csrf");
    } else if (s_id == null) {
        response.sendRedirect("/csrf/pose_list.jsp");
    }

    try {
        Dotenv dotenv = Dotenv.load();

        String dbURL = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbDriver = dotenv.get("DB_DRIVER");

        Class.forName(dbDriver);
        Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);


        System.out.println("[DEBUG] post_modify_send.jsp: sessionName = " + s_name);
        request.setCharacterEncoding("UTF-8");

        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String num = request.getParameter("num");
        String csrfToken = request.getParameter("csrfToken");
        System.out.println("[DEBUG] post_modify_send.jsp: writer = " + writer + ", title = " + title + ", content = " + content + ", num = " + num + ", csrfToken = " + csrfToken);

        assert csrf_token != null;
        if (!csrf_token.equals(csrfToken) || !s_name.equals(writer)) {
            System.out.println("[WARNING] CSRF token mismatch or writer mismatch! Possible CSRF attack.");
            response.sendRedirect("/csrf/post_list.jsp");
            return;
        }


        PreparedStatement psmt;

        String insertQuery = "UPDATE practice_board set title=?, writer=?, content=? WHERE num=" + num;
        psmt = connection.prepareStatement(insertQuery);

        psmt.setString(1, title);
        psmt.setString(2, writer);
        psmt.setString(3, content);

        psmt.executeUpdate();

        response.sendRedirect("/csrf/post_list.jsp");

    } catch (Exception ex) {
        ex.printStackTrace();
        out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
    }
%>
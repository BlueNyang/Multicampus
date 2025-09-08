<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@ page import="io.github.cdimascio.dotenv.Dotenv" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("utf-8"); // post방식 한글처리
    String id = request.getParameter("id");
    String pw = request.getParameter("pass");
    System.out.println("[DEBUG] login_action.jsp: received id = " + id + ", pw = " + pw);

    try {
        Dotenv dotenv = Dotenv.load();

        String dbURL = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbDriver = dotenv.get("DB_DRIVER");
        Class.forName(dbDriver);
        Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);

        request.setCharacterEncoding("UTF-8");

        String insertQuery = "SELECT * FROM member WHERE mem_id='" + id + "' and mem_pwd='" + pw + "'";

        PreparedStatement pstmt = connection.prepareStatement(insertQuery);

        ResultSet result = pstmt.executeQuery();

        if (result.next()) { // 결과가 있음
            String dbId = result.getString("mem_id");
//            String dbPwd = result.getString("mem_pwd");
            String dbName = result.getString("mem_name");
            //로그인증명을 위한 session 생성 - Client 별로 생성됨 > Client를 구별할 수 있는 값을 이용해 Session 속성 생성
            session.setAttribute("sessionID", dbId); //세션에 id 저장
            session.setAttribute("sessionName", dbName); //세션에 이름 저장
        }
        response.sendRedirect("post_list.jsp"); //로그인 후 목록페이지로 이동
    } catch (Exception ex) {
        ex.printStackTrace();
        out.println("DB연결에러:" + ex.getMessage());
    }
%>
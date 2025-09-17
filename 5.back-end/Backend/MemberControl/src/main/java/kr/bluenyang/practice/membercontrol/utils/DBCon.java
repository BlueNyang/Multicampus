package kr.bluenyang.practice.membercontrol.utils;

import lombok.Getter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCon {
    @Getter
    public static final DBCon instance = new DBCon();

    private DataSource ds;

    private DBCon() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/OracleXE");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    public static void DBClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

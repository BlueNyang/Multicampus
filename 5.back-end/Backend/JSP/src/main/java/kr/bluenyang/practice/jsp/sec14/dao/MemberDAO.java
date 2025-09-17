package kr.bluenyang.practice.jsp.sec14.dao;

import kr.bluenyang.practice.jsp.sec14.domain.MemberVO;
import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
    @Getter
    private static final MemberDAO instance = new MemberDAO();

    private DataSource ds;
    private Connection conn;
    private PreparedStatement pstmt;

    private MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/OracleXE");
        } catch (NamingException e) {
            System.out.println(e.getMessage());
        }
    }

    public MemberVO getMember(String id) {
        ResultSet rs = null;
        MemberVO member = null;

        try {
            conn = ds.getConnection();
            String query = "select * from member2 where mem_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                member = new MemberVO(
                        rs.getString("mem_id"),
                        rs.getString("mem_pwd"),
                        rs.getString("mem_name"),
                        rs.getString("mem_email"),
                        rs.getDate("mem_join_date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose(conn, pstmt, rs);
        }
        return member;
    }

    public List<MemberVO> memberSelect() {
        ResultSet rs = null;

        List<MemberVO> list = new ArrayList<>();
        try {
            conn = ds.getConnection();
            String query = "select * from member2";
            pstmt = conn.prepareStatement(query);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                MemberVO member = new MemberVO(
                        rs.getString("mem_id"),
                        rs.getString("mem_pwd"),
                        rs.getString("mem_name"),
                        rs.getString("mem_email"),
                        rs.getDate("mem_join_date").toLocalDate()
                );
                list.add(member);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose(conn, pstmt, rs);
        }
        return list;
    }

    public void insertMember(MemberVO member) {
        try {
            conn = ds.getConnection();
            String query = "insert into member2 values (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.id());
            pstmt.setString(2, member.pwd());
            pstmt.setString(3, member.name());
            pstmt.setString(4, member.email());
            pstmt.setDate(5, Date.valueOf(member.joinDate()));

            int rows = pstmt.executeUpdate();
            System.out.println("Inserted " + rows + " row(s).");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose(conn, pstmt, null);
        }
    }

    public void updateMember(MemberVO member) {
        try {
            conn = ds.getConnection();
            String query = "update member2 set mem_pwd = ?, mem_name = ?, mem_email = ? where mem_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.pwd());
            pstmt.setString(2, member.name());
            pstmt.setString(3, member.email());
            pstmt.setString(4, member.id());

            int rows = pstmt.executeUpdate();
            System.out.println("Updated " + rows + " row(s).");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose(conn, pstmt, null);
        }
    }

    public void deleteMember(String id) {
        try {
            conn = ds.getConnection();
            String query = "delete from member2 where mem_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            int rows = pstmt.executeUpdate();
            System.out.println("Deleted " + rows + " row(s).");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose(conn, pstmt, null);
        }
    }

    public void DBClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

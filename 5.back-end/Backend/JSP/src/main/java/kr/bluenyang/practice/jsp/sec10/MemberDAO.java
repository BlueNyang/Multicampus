package kr.bluenyang.practice.jsp.sec10;

import kr.bluenyang.practice.jsp.util.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public MemberVO getMember(String id) {
        DBConnect dbcon = new DBConnect();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberVO member = null;

        try {
            conn = dbcon.getConnection();

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
            DBConnect.close(conn, pstmt, rs);
        }
        return member;
    }

    public List<MemberVO> memberSelect() {
        DBConnect dbcon = new DBConnect();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<MemberVO> list = new ArrayList<>();
        try {
            conn = dbcon.getConnection();

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
            DBConnect.close(conn, pstmt, rs);
        }
        return list;
    }

    public void insertMember(MemberVO member) {
        DBConnect dbcon = new DBConnect();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbcon.getConnection();

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
            DBConnect.close(conn, pstmt);
        }
    }

    public void updateMember(MemberVO member) {
        DBConnect dbcon = new DBConnect();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbcon.getConnection();

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
            DBConnect.close(conn, pstmt);
        }
    }

    public void deleteMember(String id) {
        DBConnect dbcon = new DBConnect();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbcon.getConnection();

            String query = "delete from member2 where mem_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            int rows = pstmt.executeUpdate();
            System.out.println("Deleted " + rows + " row(s).");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnect.close(conn, pstmt);
        }
    }
}

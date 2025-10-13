package kr.bluenyang.practice.membercontrol.dao;

import kr.bluenyang.practice.membercontrol.domain.member.MemberVO;
import kr.bluenyang.practice.membercontrol.utils.DBCon;
import lombok.Getter;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static kr.bluenyang.practice.membercontrol.utils.DBCon.DBClose;

public class MemberDAO {
    @Getter
    private static final MemberDAO instance = new MemberDAO();
    private final DBCon dbcon;

    private Connection conn;
    private PreparedStatement pstmt;

    private MemberDAO() {
        dbcon = DBCon.getInstance();
    }

    public MemberVO getMember(String id) {
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
            DBClose(conn, pstmt, rs);
        }
        return member;
    }

    public List<MemberVO> memberSelect() {
        ResultSet rs = null;

        List<MemberVO> list = new ArrayList<>();
        try {
            list = Arrays.asList(
                    new MemberVO("M001", "pwd", "Alice", "alice@example.com", null),
                    new MemberVO("M002", "pwd", "Bob", "bob@example.com", null),
                    new MemberVO("M003", "pwd", "Charlie", "charlie@example.com", null)
            );
        } finally {
            DBClose(conn, pstmt, rs);
        }
        return list;
    }

    public void insertMember(MemberVO member) {
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
            DBClose(conn, pstmt, null);
        }
    }

    public void updateMember(MemberVO member) {
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
            DBClose(conn, pstmt, null);
        }
    }

    public void deleteMember(String id) {
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
            DBClose(conn, pstmt, null);
        }
    }
}

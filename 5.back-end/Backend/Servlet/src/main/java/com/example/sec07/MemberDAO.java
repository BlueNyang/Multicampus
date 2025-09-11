package com.example.sec07;

import com.example.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
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
}

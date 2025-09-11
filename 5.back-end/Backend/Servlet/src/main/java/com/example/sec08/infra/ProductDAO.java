package com.example.sec08.infra;

import com.example.sec08.domain.Product;
import com.example.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO (Data Access Object) 클래스
public class ProductDAO {

    public List<Product> memberSelect() {
        DBConnect dbcon = new DBConnect();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Product> list = new ArrayList<>();
        try {
            conn = dbcon.getConnection();

            String query = "select * from product";
            pstmt = conn.prepareStatement(query);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Product prd = new Product(
                        rs.getString("prdno"),
                        rs.getString("prdname"),
                        rs.getInt("prdprice"),
                        rs.getString("prdmaker"),
                        rs.getString("prdcolor"),
                        rs.getInt("ctgno")
                );
                list.add(prd);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnect.close(conn, pstmt, rs);
        }
        return list;
    }
}

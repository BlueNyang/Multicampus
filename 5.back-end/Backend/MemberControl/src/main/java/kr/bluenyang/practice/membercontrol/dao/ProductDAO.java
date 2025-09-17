package kr.bluenyang.practice.membercontrol.dao;

import kr.bluenyang.practice.membercontrol.domain.product.Product;
import kr.bluenyang.practice.membercontrol.utils.DBCon;
import lombok.Getter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kr.bluenyang.practice.membercontrol.utils.DBCon.DBClose;

public class ProductDAO {
    @Getter
    private static final ProductDAO instance = new ProductDAO();
    private final DBCon dbcon;
    private Connection conn;
    private PreparedStatement pstmt;

    private ProductDAO() {
        dbcon = DBCon.getInstance();
    }

    public Product getProduct(String prdNo) {
        ResultSet rs = null;
        Product product = null;

        try {
            conn = dbcon.getConnection();
            String query = "select * from product where prdNo = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prdNo);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                product = new Product(
                        rs.getString("prdNo"),
                        rs.getString("prdName"),
                        rs.getInt("prdPrice"),
                        rs.getString("prdMaker"),
                        rs.getString("prdColor"),
                        rs.getInt("ctgNo")
                );
                System.out.println(product.getPrdName());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose(conn, pstmt, rs);
        }
        return product;
    }

    public List<Product> getProductList() {
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();

        try {
            conn = dbcon.getConnection();
            String query = "select * from product";
            pstmt = conn.prepareStatement(query);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                        rs.getString("prdNo"),
                        rs.getString("prdName"),
                        rs.getInt("prdPrice"),
                        rs.getString("prdMaker"),
                        rs.getString("prdColor"),
                        rs.getInt("ctgNo")
                );
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose(conn, pstmt, rs);
        }
        return productList;
    }

    public void insertProduct(Product product) {
        try {
            conn = dbcon.getConnection();
            String query = "insert into product values (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, product.getPrdNo());
            pstmt.setString(2, product.getPrdName());
            pstmt.setInt(3, product.getPrdPrice());
            pstmt.setString(4, product.getPrdMaker());
            pstmt.setString(5, product.getPrdColor());
            pstmt.setInt(6, product.getCtgNo());

            System.out.println(pstmt);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose(conn, pstmt, null);
        }
    }

    public void updateProduct(Product product) {
        try {
            conn = dbcon.getConnection();
            String query = "update product set prdName = ?, prdPrice = ?, prdMaker = ?, prdColor = ?, ctgNo = ? where prdNo = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, product.getPrdName());
            pstmt.setInt(2, product.getPrdPrice());
            pstmt.setString(3, product.getPrdMaker());
            pstmt.setString(4, product.getPrdColor());
            pstmt.setInt(5, product.getCtgNo());
            pstmt.setString(6, product.getPrdNo());

            System.out.println(pstmt);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose(conn, pstmt, null);
        }
    }

    public void deleteProduct(String prdNo) {
        try {
            conn = dbcon.getConnection();
            String query = "delete from product where prdNo = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prdNo);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose(conn, pstmt, null);
        }
    }
}

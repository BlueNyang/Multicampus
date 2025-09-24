package kr.bluenyang.practice.sec02.dao;

import kr.bluenyang.practice.sec02.dto.ProductDTO;
import kr.bluenyang.practice.util.DBConnect;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final DBConnect db;

    public ArrayList<ProductDTO> memberSelect() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 데이터 저장해서 반환할 ArrayList 객체 생성
        ArrayList<ProductDTO> memList = new ArrayList<>();


        try {
            log.info("MemberDAO.memberSelect - Retrieving member information...");
            // con = getConnection();
            con = db.getConnection();

            String sql = "select * from product";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            log.info("MemberDAO.memberSelect - Executed query: {}", sql);

            while (rs.next()) {
                log.info("MemberDAO.memberSelect - Processing row...");
                // 한 행(1명) 처리
                String prdNo = rs.getString("prdno");
                String prdName = rs.getString("prdname");
                int prdPrice = rs.getInt("prdprice");
                String prdMaker = rs.getString("prdmaker");
                String prdColor = rs.getString("prdcolor");
                int ctgNo = rs.getInt("ctgno");

                // ProductDTO에 담아서
                ProductDTO dto = new ProductDTO(
                        prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo
                );

                // ArrayList에 추가
                memList.add(dto);
            }
        } catch (SQLException e) {
            log.error("MemberDAO.memberSelect - SQL Error: {}", e.getMessage());
        } finally {
            DBConnect.close(con, ps, rs);
        }

        return memList; // ArrayList 반환
    }
}

package kr.bluenyang.practice.sec01.dao;

import kr.bluenyang.practice.sec01.dto.MemberDTO;
import kr.bluenyang.practice.util.DBConnect;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final DBConnect db;

    // 회원 정보 조회 메소드 (전체 회원 정보 SELECT 해서 반환)
    // MemberDTO로 받아서 ArrayList에 저장 후 ArrayList 객체 memList 반환
    public ArrayList<MemberDTO> memberSelect() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 데이터 저장해서 반환할 ArrayList 객체 생성
        ArrayList<MemberDTO> memList = new ArrayList<>();


        try {
            log.info("MemberDAO.memberSelect - Retrieving member information...");
            // con = getConnection();
            con = db.getConnection();

            String sql = "select * from member2";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            log.info("MemberDAO.memberSelect - Executed query: {}", sql);

            while (rs.next()) {
                log.info("MemberDAO.memberSelect - Processing row...");
                // 한 행(1명) 처리
                String memId = rs.getString("mem_id"); // 순서 번호 1, 2, 3... 사용해도 되고, 열 이름 사용해도 됨
                String memPwd = rs.getString("mem_pwd");
                String memName = rs.getString("mem_name");
                String memEmail = rs.getString("mem_email");
                Date memJoinDate = rs.getDate("mem_join_date");

                // MemberDTO에 담아서
                MemberDTO dto = new MemberDTO();
                dto.setMemId(memId);
                dto.setMemPwd(memPwd);
                dto.setMemName(memName);
                dto.setMemEmail(memEmail);
                dto.setMemJoinDate(memJoinDate);

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





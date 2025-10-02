package kr.bluenyang.practice.springbootex.auth.dao;

import kr.bluenyang.practice.springbootex.auth.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
    /**
     * ID 값으로 회원 조회
     *
     * @param memId 회원 ID
     * @return 회원 정보
     */
    Member findMemberById(String memId);

    /**
     * DB에 회원 정보 삽입
     *
     * @param member 회원 정보
     */
    void insertMember(Member member);

    /**
     * 회원 정보 수정
     *
     * @param member 회원 정보
     */
    void updateMember(Member member);

    /**
     * 회원 정보 삭제
     *
     * @param memId 회원 ID
     */
    void deleteMember(String memId);
}

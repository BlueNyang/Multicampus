package kr.bluenyang.practice.springbootex.auth.dao;

import kr.bluenyang.practice.springbootex.auth.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
    Member findMemberById(String memId);

    void insertMember(Member member);

    void updateMember(Member member);

    void deleteMember(String memId);
}

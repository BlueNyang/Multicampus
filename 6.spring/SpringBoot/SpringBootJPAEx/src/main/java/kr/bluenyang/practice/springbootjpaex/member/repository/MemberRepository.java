package kr.bluenyang.practice.springbootjpaex.member.repository;

import kr.bluenyang.practice.springbootjpaex.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, String> {

    /**
     * 로그인 체크용 메서드
     *
     * @param memId 아이디
     * @return 암호화된 비밀번호(존재하지 않으면 null)
     */
    @Query("SELECT m.memPwd FROM Member m WHERE m.memId = :memId")
    String getPwdByMemId(@Param("memId") String memId);
}

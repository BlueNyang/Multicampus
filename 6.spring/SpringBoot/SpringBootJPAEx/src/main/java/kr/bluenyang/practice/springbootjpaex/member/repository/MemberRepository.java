package kr.bluenyang.practice.springbootjpaex.member.repository;

import kr.bluenyang.practice.springbootjpaex.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    /**
     * Method for login: retrieve encrypted password by member ID
     *
     * @param memId user ID
     * @return Encrypted password if user exists, else empty
     */
    @Query("SELECT m.memPwd FROM Member m WHERE m.memId = :memId")
    Optional<String> getPwdByMemId(@Param("memId") String memId);
}

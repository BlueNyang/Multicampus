package kr.bluenyang.practice.springbootex.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * Member 정보를 수정하기 위한 DTO (Data Transfer Object).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberEditDTO {
    private String memId;
    private String memPwd;
    // 새 비밀번호 필드 추가
    private String newMemPwd;
    private String memName;
    private String memEmail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date memJoinDate;
    private String memHp1;
    private String memHp2;
    private String memHp3;
    private String memZipCode;
    private String memAddress1;
    private String memAddress2;

    /**
     * DTO를 Entity로 변환.
     *
     * @return Member 엔티티
     */
    public MemberVO toVO() {
        return new MemberVO(
                this.memId,
                this.newMemPwd.isEmpty() ? this.memPwd : this.newMemPwd,
                this.memName,
                this.memEmail,
                this.memJoinDate,
                this.memHp1 + "-" + this.memHp2 + "-" + this.memHp3,
                this.memZipCode,
                this.memAddress1,
                this.memAddress2
        );
    }
}

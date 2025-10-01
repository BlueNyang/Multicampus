package kr.bluenyang.practice.springbootex.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String memId;
    private String memPwd;
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

    public MemberDTO(Member member) {
        this.memId = member.getMemId();
        this.memPwd = member.getMemPwd();
        this.memName = member.getMemName();
        this.memEmail = member.getMemEmail();
        this.memJoinDate = member.getMemJoinDate();

        String[] hpParts = member.getMemHp().split("-");
        if (hpParts.length == 3) {
            this.memHp1 = hpParts[0];
            this.memHp2 = hpParts[1];
            this.memHp3 = hpParts[2];
        } else {
            this.memHp1 = "";
            this.memHp2 = "";
            this.memHp3 = "";
        }

        this.memZipCode = member.getMemZipCode();
        this.memAddress1 = member.getMemAddress1();
        this.memAddress2 = member.getMemAddress2();
    }

    public Member toEntity() {
        return new Member(
                this.memId,
                this.memPwd,
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

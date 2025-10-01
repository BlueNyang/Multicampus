package kr.bluenyang.practice.springbootex.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberEditDTO {
    private String memId;
    private String memPwd;
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

    public Member toEntity() {
        return new Member(
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

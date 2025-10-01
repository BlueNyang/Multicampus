package kr.bluenyang.practice.springbootex.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class Member {
    private String memId;
    private String memPwd;
    private String memName;
    private String memEmail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date memJoinDate;
    private String memHp;
    private String memZipCode;
    private String memAddress1;
    private String memAddress2;
}

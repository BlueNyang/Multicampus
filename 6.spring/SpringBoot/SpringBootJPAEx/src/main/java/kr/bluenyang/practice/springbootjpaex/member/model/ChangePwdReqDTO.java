package kr.bluenyang.practice.springbootjpaex.member.model;

import lombok.Data;

@Data
public class ChangePwdReqDTO {
    private String memId;
    private String currentPwd;
    private String newPwd;
}

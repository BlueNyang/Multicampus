package kr.bluenyang.practice.springbootjpaex.member.model;

import lombok.Data;

@Data
public class LoginReqDTO {
    private String memId;
    private String memPwd;
}

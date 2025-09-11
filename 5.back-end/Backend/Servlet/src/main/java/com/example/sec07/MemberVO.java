package com.example.sec07;

import java.time.LocalDate;
import java.util.Objects;

public class MemberVO {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private LocalDate joinDate;

    public MemberVO(String id, String pwd, String name, String email, LocalDate joinDate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.joinDate = joinDate;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemberVO memberVO = (MemberVO) o;
        return Objects.equals(id, memberVO.id) && Objects.equals(pwd, memberVO.pwd) && Objects.equals(name, memberVO.name) && Objects.equals(email, memberVO.email) && Objects.equals(joinDate, memberVO.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pwd, name, email, joinDate);
    }
}

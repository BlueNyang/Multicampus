package com.mc.g_factory;

public enum EmailConfig {
    NAVER("smtp.naver.com", "mc", "123abc", 5000),
    DAUM("smtp.daum.net", "mc", "123abc", 5000),
    GOOGLE("smtp.gmail.com", "mc", "123abc", 5000);

    final String url;
    final String id;
    final String pwd;
    final int timeout;

    EmailConfig(String url, String id, String pwd, int timeout) {
        this.url = url;
        this.id = id;
        this.pwd = pwd;
        this.timeout = timeout;
    }
}

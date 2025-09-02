package com.mc.g_factory;

public class NaverMail implements SMTPConnector {
    private EmailConfig config;

    public NaverMail(EmailConfig config) {
        this.config = config;
    }

    @Override
    public void connect() {
        System.out.println(config.url);
        System.out.println("네이버 메일 서버에 연결합니다.");
    }
}

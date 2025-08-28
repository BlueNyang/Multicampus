package com.mc.g_factory;

public class GoogleMail implements SMTPConnector {
    private EmailConfig config;

    public GoogleMail(EmailConfig config) {
        this.config = config;
    }

    @Override
    public void connect() {
        System.out.println(config.url);
        System.out.println("구글 메일 서버에 연결합니다.");
    }
}

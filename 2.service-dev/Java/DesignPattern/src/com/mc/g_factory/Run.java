package com.mc.g_factory;

public class Run {
    public static void main(String[] args) {
        SMTPConnector mail = ConnectorFactory.create(EmailConfig.NAVER);
        mail.connect();
    }
}

package com.mc.g_factory;

public class ConnectorFactory {
    public static SMTPConnector create(EmailConfig config) {
        return switch (config) {
            case NAVER -> new NaverMail(config);
            case DAUM -> new DaumMail(config);
            case GOOGLE -> new GoogleMail(config);
        };
    }
}

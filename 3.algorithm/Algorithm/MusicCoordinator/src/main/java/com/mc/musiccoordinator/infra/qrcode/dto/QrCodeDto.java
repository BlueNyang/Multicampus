package com.mc.musiccoordinator.infra.qrcode.dto;

public record QrCodeDto(String text, String fileName, int width, int height, String format, int color) {

    public QrCodeDto(String text, String fileName) {
        this(text, fileName, 300, 300, "PNG", 0x1080ef00);
    }
}

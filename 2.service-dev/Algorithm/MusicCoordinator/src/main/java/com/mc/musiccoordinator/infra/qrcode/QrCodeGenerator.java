package com.mc.musiccoordinator.infra.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mc.musiccoordinator.infra.qrcode.dto.QrCodeDto;

import java.io.FileOutputStream;
import java.io.IOException;

public class QrCodeGenerator {

    public void generate(QrCodeDto qrCodeDto) {
        try (FileOutputStream fos = new FileOutputStream(qrCodeDto.fileName() + "." + qrCodeDto.format())) {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            BitMatrix bitMatrix = qrCodeWriter.encode(
                    qrCodeDto.text(), BarcodeFormat.QR_CODE,
                    qrCodeDto.width(), qrCodeDto.height()
            );

            MatrixToImageWriter.writeToStream(
                    bitMatrix, qrCodeDto.format(), fos
            );

            System.out.println("QR 코드가 성공적으로 생성되었습니다. 파일명: " + qrCodeDto.fileName());
        } catch (WriterException | IOException e) {
            System.out.println("QR 코드 생성 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}

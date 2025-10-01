package kr.bluenyang.practice.springbootmybatis.file;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@Controller
public class FileDownloadController {
    private final String FILE_STORE_PATH = "W:/MyWorks/JAVA_Dev_Full-Stack-Academy/6.spring/FileStore/";

    @GetMapping("/fileDownloadList")
    public String fileDownloadList(Model model) {
        File path = new File(FILE_STORE_PATH);
        String[] fileList = path.list();

        model.addAttribute("fileList", fileList);

        return "file/fileDownloadList";
    }

    @GetMapping("/fileDownload/{fileName}")
    public void fileDownload(@PathVariable("fileName") String fileName, HttpServletResponse resp) throws IOException {
        // 1. 다운로드할 파일 경로 설정 및 File 객체 생성
        File f = new File(FILE_STORE_PATH, fileName);

        // 한글 파일명 깨짐 방지 처리
        String encodedFileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

        // 2. HTTP 응답 헤더 설정
        resp.setContentType("application/download; charset=utf-8");
        resp.setContentLength((int) f.length());
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");

        // 3. 파일을 읽어서 HTTP 응답 바디에 쓰기
        FileInputStream fis = new FileInputStream(f);
        OutputStream os = resp.getOutputStream();

        // 파일 전송
        FileCopyUtils.copy(fis, os);
    }
}

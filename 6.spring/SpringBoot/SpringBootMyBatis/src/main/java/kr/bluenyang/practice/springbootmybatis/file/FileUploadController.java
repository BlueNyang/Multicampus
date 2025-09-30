package kr.bluenyang.practice.springbootmybatis.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
public class FileUploadController {
    @GetMapping("/fileUploadForm")
    public String ViewUploadForm() {
        log.info("FileUploadController.ViewUploadForm - load upload form");
        return "upload/fileUploadForm";
    }

    @GetMapping("/fileUploadResult")
    public String ViewUploadResult() {
        log.info("FileUploadController.ViewUploadResult - load upload result");
        return "upload/fileUploadResult";
    }

    @PostMapping("/fileUpload")
    public String fileUpload(@RequestParam("uploadFile") MultipartFile file,
                             RedirectAttributes ra) throws IOException {
        log.info("FileUploadController.fileUpload - upload requested");

        // 1. 파일 저장 결로 설정 - Directory 마지막에 / 포함할 것
        String uploadPath = "W:/MyWorks/JAVA_Dev_Full-Stack-Academy/6.spring/FileStore/";

        // 2. 전송된 원본 파일 이름 가져오기
        String originalFileName = file.getOriginalFilename();

        // 3. 저장할 파일 이름 중복 방지 처리
        // 서버에 저장할 파일 이름 == UUID_원본파일이름
        UUID uuid = UUID.randomUUID();
        String saveFileName = uuid + "_" + originalFileName;

        // 4. 파일 저장
        File destFile = new File(uploadPath + saveFileName);
        file.transferTo(destFile);

        // Client에게 전송한 파일의 전송 결과를 표현
        log.info("FileUploadController.fileUpload - file uploaded: {}", originalFileName);

        ra.addFlashAttribute("originalFileName", originalFileName);
        return "redirect:/file/fileUploadResult";
    }

    @GetMapping("/fileUploadMultipleResult")
    public String ViewUploadMultipleResult() {
        log.info("FileUploadController.ViewUploadMultipleResult - load upload multiple result");
        return "upload/fileUploadMultipleResult";
    }

    @PostMapping("/fileUploadMultiple")
    public String fileUploadMultiple(@RequestParam("uploadFiles") MultipartFile[] files,
                                     RedirectAttributes ra) throws IOException {
        log.info("FileUploadController.fileUploadMultiple - multiple file upload requested");

        // 1. 파일 저장 결로 설정 - Directory 마지막에 / 포함할 것
        String uploadPath = "W:/MyWorks/JAVA_Dev_Full-Stack-Academy/6.spring/FileStore/";

        List<String> originalFileNames = new LinkedList<>();
        for (MultipartFile file : files) {
            // 2. 전송된 원본 파일 이름 가져오기
            String originalFileName = file.getOriginalFilename();

            // 3. 저장할 파일 이름 중복 방지 처리
            // 서버에 저장할 파일 이름 == UUID_원본파일이름
            UUID uuid = UUID.randomUUID();
            String saveFileName = uuid + "_" + originalFileName;

            // 4. 파일 저장
            File destFile = new File(uploadPath + saveFileName);
            file.transferTo(destFile);

            originalFileNames.add(originalFileName);
            log.info("FileUploadController.fileUploadMultiple - file uploaded: {}", originalFileName);
        }

        ra.addFlashAttribute("originalFileNames", originalFileNames);
        return "redirect:/file/fileUploadMultipleResult";
    }

    @PostMapping("/fileOriginalNameUpload")
    public String fileOriginalNameUpload(@RequestParam("uploadFile") MultipartFile file,
                                         RedirectAttributes ra) throws IOException {
        log.info("FileUploadController.fileOriginalNameUpload - upload requested");

        // 1. 파일 저장 결로 설정 - Directory 마지막에 / 포함할 것
        String uploadPath = "W:/MyWorks/JAVA_Dev_Full-Stack-Academy/6.spring/FileStore/";

        // 2. 전송된 원본 파일 이름 가져오기
        String originalFileName = file.getOriginalFilename();

        // 3. 파일 저장
        File destFile = new File(uploadPath + originalFileName);
        file.transferTo(destFile);

        // Client에게 전송한 파일의 전송 결과를 표현
        log.info("FileUploadController.fileOriginalNameUpload - file uploaded: {}", originalFileName);

        ra.addFlashAttribute("originalFileName", originalFileName);
        return "redirect:/file/fileUploadResult";
    }

    @PostMapping("/imageFileUploadForm")
    public String
}

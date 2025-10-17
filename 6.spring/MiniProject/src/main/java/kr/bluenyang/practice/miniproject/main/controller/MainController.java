package kr.bluenyang.practice.miniproject.main.controller;

import kr.bluenyang.practice.miniproject.main.model.BannerImageDTO;
import kr.bluenyang.practice.miniproject.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService service;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @ResponseBody
    @GetMapping("/get/slides")
    public List<BannerImageDTO> getSlideBannerImages() {
        return service.getBannerImages();
    }
}

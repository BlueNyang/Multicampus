package kr.bluenyang.practice.miniproject.main.controller;

import kr.bluenyang.practice.miniproject.main.model.BannerImageDTO;
import kr.bluenyang.practice.miniproject.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class MainController {
    MainService service;

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

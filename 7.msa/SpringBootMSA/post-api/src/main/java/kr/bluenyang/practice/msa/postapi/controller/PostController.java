package kr.bluenyang.practice.msa.postapi.controller;

import kr.bluenyang.practice.msa.postapi.model.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
    private final RestTemplate restTemplate;

    @GetMapping("/posts")
    public Post[] posts() {
        return restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts",
                Post[].class
        );
    }

    @GetMapping("/posts/{postId}")
    public Post post(@PathVariable long postId) {
        var url = String.format("https://jsonplaceholder.typicode.com/posts/%d", postId);
        log.info("url: {}", url);
        return restTemplate.getForObject(url, Post.class);
    }
}

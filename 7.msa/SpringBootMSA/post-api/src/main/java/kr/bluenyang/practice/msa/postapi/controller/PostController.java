package kr.bluenyang.practice.msa.postapi.controller;

import kr.bluenyang.practice.msa.postapi.model.Comment;
import kr.bluenyang.practice.msa.postapi.model.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Object> post(@PathVariable String postId) {
        var url = String.format("https://jsonplaceholder.typicode.com/posts/%s", postId);
        log.info("url: {}", url);
        var post = restTemplate.getForObject(url, Post.class);

        url = String.format("http://localhost:8082/comments?postId=%s", postId);
        var comments = restTemplate.getForObject(url, Comment[].class);

        var map = new HashMap<String, Object>();
        map.put("post", post);
        map.put("comments", comments);

        return map;
    }
}

package kr.bluenyang.practice.msa.commentapi.controller;

import kr.bluenyang.practice.msa.commentapi.model.Comment;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final RestTemplate restTemplate;
    private static final Log logger = LogFactory.getLog(CommentController.class);

    @GetMapping("/comments")
    public Comment[] comments(@RequestParam(defaultValue = "1") String postId) {
        logger.info("comments() has been called");

        var url = String.format("https://jsonplaceholder.typicode.com/comments?postId=%s", postId);
        return restTemplate.getForObject(url, Comment[].class);
    }
}

package kr.bluenyang.practice.msa.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GatewayApplication {

    @Value("${post.api.uri}")
    private static String postUri;

    @Value("${comment.api.uri}")
    private static String commentUri;

    public static void main(String[] args) {
        log.info("postUri: {}, commentUri: {}", postUri, commentUri);

        SpringApplication.run(GatewayApplication.class, args);
    }
}

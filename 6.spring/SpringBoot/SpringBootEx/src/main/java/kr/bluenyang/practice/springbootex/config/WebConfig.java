package kr.bluenyang.practice.springbootex.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"kr.bluenyang.practice.springbootex"})
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer cfg) {
        cfg.addPathPrefix(
                "/shop",
                HandlerTypePredicate.forBasePackage("kr.bluenyang.prectice.springbootex.shop")
        );
    }
}

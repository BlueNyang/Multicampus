package kr.bluenyang.practice.springbootmybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"kr.bluenyang.practice.springbootmybatis"})
@MapperScan("kr.bluenyang.practice.springbootmybatis.*.dao")
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer cfg) {
        cfg.addPathPrefix(
                "/product",
                HandlerTypePredicate.forBasePackage("kr.bluenyang.practice.springbootmybatis.product")
        );
        cfg.addPathPrefix(
                "/file",
                HandlerTypePredicate.forBasePackage("kr.bluenyang.practice.springbootmybatis.file")
        );
    }
}

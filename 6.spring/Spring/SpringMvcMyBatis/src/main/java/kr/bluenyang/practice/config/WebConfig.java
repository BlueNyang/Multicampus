package kr.bluenyang.practice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@MapperScan("kr.bluenyang.practice.*.dao")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer cfg) {
        cfg.addPathPrefix(
                "/product",
                c -> c.getPackage().getName().startsWith("kr.bluenyang.practice.product")
        );
        cfg.addPathPrefix(
                "/book",
                c -> c.getPackage().getName().startsWith("kr.bluenyang.practice.book")
        );
    }

    // Add resource handler for serving static resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}


package kr.bluenyang.practice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer cfg) {
        cfg.addPathPrefix(
                "/sec01",
                c -> c.getPackage().getName().startsWith(
                        "kr.bluenyang.practice.sec01"
                )
        );
        cfg.addPathPrefix(
                "/sec02",
                c -> c.getPackage().getName().startsWith(
                        "kr.bluenyang.practice.sec02"
                )
        );
    }

    // Add resource handler for serving static resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}

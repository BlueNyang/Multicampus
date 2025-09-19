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
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(
                "/sec01",
                c -> c.getPackage().getName().startsWith(
                        "kr.bluenyang.practice.sec01"
                )
        );
        configurer.addPathPrefix(
                "/sec02",
                c -> c.getPackage().getName().startsWith(
                        "kr.bluenyang.practice.sec02"
                )
        );
        configurer.addPathPrefix(
                "/sec03",
                c -> c.getPackage().getName().startsWith(
                        "kr.bluenyang.practice.sec03"
                )
        );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}

package kr.bluenyang.practice.springbootjpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/product_images/**")
                .addResourceLocations("file:///W:/MyWorks/JAVA_Dev_Full-Stack-Academy/6.spring/product_images/");
    }
}

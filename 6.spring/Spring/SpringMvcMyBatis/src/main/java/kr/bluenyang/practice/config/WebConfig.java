package kr.bluenyang.practice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@MapperScan("kr.bluenyang.practice.*.dao")
public class WebConfig implements WebMvcConfigurer {

    // Inject the product images path from application properties
    @Value("${product.image.path}")
    private String productImagesPath;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    public void configureDefaultServerletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // Configure path prefixes for different packages
    @Override
    public void configurePathMatch(PathMatchConfigurer cfg) {
        // Product Package
        cfg.addPathPrefix(
                "/product",
                c -> c.getPackage().getName().startsWith("kr.bluenyang.practice.product")
        );
        // Book Package
        cfg.addPathPrefix(
                "/book",
                c -> c.getPackage().getName().startsWith("kr.bluenyang.practice.book")
        );
    }

    // Add resource handler for serving static resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/images/product/**").addResourceLocations(productImagesPath);
    }
}


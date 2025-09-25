package kr.bluenyang.practice.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

public class WebFilter implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());

        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");

        encodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}

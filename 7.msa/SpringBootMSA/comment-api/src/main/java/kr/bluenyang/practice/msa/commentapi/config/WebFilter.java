package kr.bluenyang.practice.msa.commentapi.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

@Component
public class WebFilter implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        var encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());

        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");

        encodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}

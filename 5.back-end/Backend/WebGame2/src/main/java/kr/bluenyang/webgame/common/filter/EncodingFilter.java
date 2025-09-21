package kr.bluenyang.webgame.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

// Encoding filter는 모든 request에 대해 UTF-8 인코딩을 설정
@Slf4j
// 모든 요청에 대해 필터 적용
@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        fc.doFilter(req, res);
    }
}

package kr.bluenyang.webgame.user.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.user.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serial;

@Slf4j
@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private UserServiceImpl userService;

    @Override
    public void init() throws ServletException {
        super.init();

        this.userService = (UserServiceImpl) getServletContext().getAttribute("userService");
    }

    // 같은 경로에 대해 GET은 로그인 폼을 보여주고
    // POST는 로그인 처리를 한다.

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("UserLoginServlet.doGet - Dispatching to loginForm.jsp");
        var dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/loginForm.jsp");

        try {
            // login.jsp로 포워딩
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            log.error("UserLoginServlet.doGet - Error forwarding to loginForm.jsp: {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var action = request.getParameter("action");
        if ("register".equals(action)) {
            // 회원가입 버튼을 눌렀을 때
            log.info("UserLoginServlet.doPost - Redirecting to registration page");
            response.sendRedirect(request.getContextPath() + "/user/register");
            return;
        }

        // 로그인 처리
        var userid = request.getParameter("userId");
        var password = request.getParameter("password");
        log.info("UserLoginServlet.doPost - Attempting login for userId: {}", userid);

        var session = request.getSession();

        // 로그인 시도
        var dto = userService.login(userid, password);
        if (dto == null) {
            // dto가 null이면 로그인 실패
            log.info("UserLoginServlet.doPost - User not found for userId: {}", userid);
            // perhaps, username이나 password가 틀렸을 것임.
            // null == user_id를 찾지 못했거나 password가 틀렸거나
            session.setAttribute("errorMessage", "Invalid username or password");
            response.sendRedirect(request.getContextPath() + "/user/login");
        } else {
            log.info("UserLoginServlet.doPost - Login successful for userId: {}", userid);
            // 로그인 성공
            session.setAttribute("user", dto);
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
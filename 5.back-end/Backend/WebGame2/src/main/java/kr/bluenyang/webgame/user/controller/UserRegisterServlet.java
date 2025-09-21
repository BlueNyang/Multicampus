package kr.bluenyang.webgame.user.controller;


import java.io.IOException;
import java.io.Serial;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.user.dto.UserDTO;
import kr.bluenyang.webgame.user.model.UserServiceResult;
import kr.bluenyang.webgame.user.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/user/register")
public class UserRegisterServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private UserServiceImpl userService;

    @Override
    public void init() throws ServletException {
        super.init();

        this.userService = (UserServiceImpl) getServletContext().getAttribute("userService");
    }

    // 같은 경로에 대해 GET은 회원가입 폼을 보여주고, POST는 회원가입 처리를 한다.

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("UserRegisterServlet.doGet - Dispatching to registerForm.jsp");
        var dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/registerForm.jsp");

        try {
            // Forward to registerForm.jsp
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            log.error("UserRegisterServlet.doGet - Error forwarding to registerForm.jsp: {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var userId = request.getParameter("userId");
        var password = request.getParameter("password");
        var username = request.getParameter("username");
        var userEmail = request.getParameter("userEmail");
        log.info("UserRegisterServlet.doPost - Registering user: {}", userId);

        var session = request.getSession();

        // Service에 DTO로 data 전달
        var result = userService.registerUser(new UserDTO(userId, password, username, userEmail));

        // 결과에 따라 다른 페이지로 redirect
        if (result == UserServiceResult.DUPLICATED) {
            // 중복된 userId
            log.info("UserRegisterServlet.doPost - Duplicate userId: {}", userId);
            session.setAttribute("errorMessage", "Username already exists");
            response.sendRedirect(request.getContextPath() + "/user/register");
        } else if (result == UserServiceResult.FAIL) {
            // 기타 오류
            log.info("UserRegisterServlet.doPost - Registration failed for user: {}", userId);
            session.setAttribute("errorMessage", "User registration failed");
            response.sendRedirect(request.getContextPath() + "/user/register");
        } else {
            // 성공
            log.info("UserRegisterServlet.doPost - User registered successfully: {}", userId);
            session.setAttribute("successMessage", "User registered successfully");
            response.sendRedirect(request.getContextPath() + "/user/login");
        }
    }
}
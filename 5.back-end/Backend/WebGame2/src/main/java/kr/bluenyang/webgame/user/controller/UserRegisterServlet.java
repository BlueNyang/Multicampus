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

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("UserRegisterServlet.doGet - Dispatching to registerForm.jsp");
        var dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/registerForm.jsp");

        try {
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

        var result = userService.registerUser(new UserDTO(userId, password, username, userEmail));
        if (result == UserServiceResult.DUPLICATED) {
            log.info("UserRegisterServlet.doPost - Duplicate userId: {}", userId);
            session.setAttribute("errorMessage", "Username already exists");
            response.sendRedirect(request.getContextPath() + "/user/register");
        } else if (result == UserServiceResult.FAIL) {
            log.info("UserRegisterServlet.doPost - Registration failed for user: {}", userId);
            session.setAttribute("errorMessage", "User registration failed");
            response.sendRedirect(request.getContextPath() + "/user/register");
        } else {
            log.info("UserRegisterServlet.doPost - User registered successfully: {}", userId);
            session.setAttribute("successMessage", "User registered successfully");
            response.sendRedirect(request.getContextPath() + "/user/login");
        }
    }
}
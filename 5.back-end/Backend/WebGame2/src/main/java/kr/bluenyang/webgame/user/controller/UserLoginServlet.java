package kr.bluenyang.webgame.user.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.user.model.UserServiceResult;
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

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("UserLoginServlet.doGet - Dispatching to loginForm.jsp");
        var dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/loginForm.jsp");

        try {
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
        var userid = request.getParameter("userId");
        var password = request.getParameter("password");
        log.info("UserLoginServlet.doPost - Attempting login for userId: {}", userid);

        var session = request.getSession();

        var dto = userService.login(userid, password);
        if (dto == null) {
            log.info("UserLoginServlet.doPost - User not found for userId: {}", userid);
            session.setAttribute("errorMessage", "Invalid username or password");
            response.sendRedirect(request.getContextPath() + "/user/login");
        } else {
            log.info("UserLoginServlet.doPost - Login successful for userId: {}", userid);
            session.setAttribute("user", dto);
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
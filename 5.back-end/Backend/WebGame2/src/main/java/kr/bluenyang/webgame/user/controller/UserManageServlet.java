package kr.bluenyang.webgame.user.controller;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.user.dto.UserDTO;
import kr.bluenyang.webgame.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serial;

@Slf4j
@WebServlet("/user/manage")
public class UserManageServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    private UserService userService;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig cfg) throws ServletException {
        super.init(cfg);
        userService = (UserService) cfg.getServletContext().getAttribute("userService");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/userManage.jsp");
        var session = request.getSession();

        // Check for updateSuccess or withdrawSuccess parameters
        // If present, set a message in session and redirect to index
        var updateSuccess = request.getParameter("updateSuccess");
        if (updateSuccess != null && updateSuccess.equals("true")) {
            session.setAttribute("msg", "성공적으로 회원정보가 수정되었습니다. 다시 로그인 해주세요.");
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        // Check for withdrawSuccess parameter
        var withdrawSuccess = request.getParameter("withdrawSuccess");
        if (withdrawSuccess != null && withdrawSuccess.equals("true")) {
            session.setAttribute("msg", "성공적으로 회원탈퇴가 처리되었습니다.");
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        // Ensure user is logged in
        var user = (UserDTO) session.getAttribute("user");
        if (user == null) {
            // Login 상태가아니면 login page로 redirect
            log.warn("UserManageServlet.doGet - No user in session, redirecting to login");
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            log.error("UserManageServlet.doGet - Error forwarding to userManage.jsp: {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // action 분류 - update, withdraw
        var action = request.getParameter("action");
        if ("update".equals(action)) {
            this.doUpdate(request, response);
        } else if ("withdraw".equals(action)) {
            this.doWithdraw(request, response);
        } else {
            log.warn("UserManageServlet.doPost - Unknown action: {}", action);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action");
        }
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 회원정보 수정 처리
        log.info("UserManageServlet.doUpdate - Processing user update");
        var userId = request.getParameter("userId");
        var currentPassword = request.getParameter("currentPassword");
        var password = request.getParameter("password");
        var username = request.getParameter("username");
        var userEmail = request.getParameter("userEmail");

        // Session and current user info
        var session = request.getSession();
        var user = (UserDTO) session.getAttribute("user");

        // password가 비어있으면, password를 변경하지 않는 것으로 간주
        if (password == null || password.isEmpty()) {
            password = user.getPassword();
        }

        log.info("UserManageServlet.doUpdate - request update for userId: {}", userId);
        // update user
        var result = userService.updateUser(
                new UserDTO(userId, password, username, userEmail),
                currentPassword
        );

        // 결과에 따른 처리
        String url = switch (result) {
            case SUCCESS -> {
                log.info("UserManageServlet.doUpdate - User update successful for userId: {}", userId);
                // Update session user info
                session.invalidate();
                // 변경된 정보로 다시 로그인 필요
                yield "/user/manage?updateSuccess=true";
            }
            case INVALID_ID_OR_PASSWORD -> {
                log.warn("UserManageServlet.doUpdate - Invalid current password for userId: {}", userId);
                // Update 실패 메시지 설정
                session.setAttribute("errorMessage", "Current password is incorrect.");
                // Redirect back to manage page with failure
                yield "/user/manage?updateSuccess=false";
            }
            case NOT_FOUND -> {
                log.warn("UserManageServlet.doUpdate - User not found for userId: {}", userId);
                // Update 실패 메시지 설정
                session.setAttribute("errorMessage", "User not found.");
                yield "/user/manage?updateSuccess=false";
            }
            default -> {
                log.warn("UserManageServlet.doUpdate - User update failed for userId: {}", userId);
                // Update 실패 메시지 설정
                session.setAttribute("errorMessage", "Failed to update user information. Please check your current password.");
                yield "/user/manage?updateSuccess=false";
            }
        };
        // Redirect to appropriate URL
        response.sendRedirect(request.getContextPath() + url);
    }

    private void doWithdraw(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("UserManageServlet.doWithdraw - Processing user withdrawal");

        // 현재 비밀번호와 userId 파라미터 받기
        var currentPassword = request.getParameter("currentPassword");
        var userId = request.getParameter("userId");

        // Session
        var session = request.getSession();

        // userId가 세션의 userId와 일치하는지 확인
        var user = (UserDTO) session.getAttribute("user");
        if (user == null || !user.getUserId().equals(userId)) {
            log.warn("UserManageServlet.doWithdraw - User ID mismatch or no user in session");
            session.setAttribute("errorMessage", "User ID mismatch or not logged in.");
            response.sendRedirect(request.getContextPath() + "/user/manage?withdrawSuccess=false");
            return;
        }
        // 회원 탈퇴 처리
        var result = userService.removeUser(userId, currentPassword);

        // 결과에 따른 처리
        var url = switch (result) {
            case SUCCESS -> {
                log.info("UserManageServlet.doWithdraw - User withdrawal successful for userId: {}", userId);
                // Invalidate session after successful withdrawal
                session.invalidate();
                yield "/?withdrawSuccess=true";
            }
            case INVALID_ID_OR_PASSWORD -> {
                log.warn("UserManageServlet.doWithdraw - Invalid current password for userId: {}", userId);
                // Set error message for invalid password
                session.setAttribute("errorMessage", "Current password is incorrect.");
                yield "/user/manage?withdrawSuccess=false";
            }
            case NOT_FOUND -> {
                log.warn("UserManageServlet.doWithdraw - User not found for userId: {}", userId);
                // Set error message for user not found
                session.setAttribute("errorMessage", "User not found.");
                yield "/user/manage?withdrawSuccess=false";
            }
            default -> {
                log.warn("UserManageServlet.doWithdraw - User withdrawal failed for userId: {}", userId);
                // Set generic error message
                session.setAttribute("errorMessage", "Failed to withdraw user. Please check your current password.");
                yield "/user/manage?withdrawSuccess=false";
            }
        };
        // Redirect to appropriate URL
        response.sendRedirect(request.getContextPath() + url);
    }
}
package kr.bluenyang.webgame.game.numbb.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballStatus;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballTryVo;
import kr.bluenyang.webgame.game.numbb.service.NumberBaseballGameService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@WebServlet("/num-baseball/guess")
public class NumberBaseballGuessServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    // Service layer object
    private NumberBaseballGameService gameService;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        super.init();
        // Get the game service from the context
        this.gameService = (NumberBaseballGameService) cfg.getServletContext().
                getAttribute("numberBaseballGameService");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var dispatcher = request.getRequestDispatcher("/WEB-INF/views/num-baseball/play.jsp");

        try {
            // Forwarding 처리
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            log.error("NumberBaseballGuessServlet.doGet - Error forwarding to play.jsp: ", e);
            // 서버 오류 발생 시 500 에러 응답
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An internal error occurred.");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("NumberBaseballGuessServlet.doPost - Processing a guess in Number Baseball Game");
        // session object
        var session = request.getSession();

        // get game objects from session
        @SuppressWarnings("unchecked")
        var secret = (List<Integer>) session.getAttribute("secret");
        @SuppressWarnings("unchecked")
        var attempts = (List<NumberBaseballTryVo>) session.getAttribute("attempts");
        var status = (NumberBaseballStatus) session.getAttribute("status");

        // Secret number가 없는 경우, 게임 시작 페이지로 리다이렉트
        if (secret == null) {
            log.info("NumberBaseballGuessServlet.doPost - Secret number not found in session. Redirecting to start a new game.");
            response.sendRedirect(request.getContextPath() + "/num-baseball/start");
            return;
        }
        // Attempts가 null인 경우, 빈 리스트로 초기화
        if (attempts == null) {
            attempts = new ArrayList<>();
        }

        // 추측 값 가져오기
        var guess = request.getParameter("guess");
        // 추측 값이 없으면 다시 추측 페이지로 리다이렉트
        if (guess == null || guess.isBlank()) {
            log.info("NumberBaseballGuessServlet.doPost - No guess provided. Redirecting back to guess page.");
            response.sendRedirect(request.getContextPath() + "/num-baseball/guess");
            return;
        }

        // 게임 서비스에 추측 값 전달
        log.info("NumberBaseballGuessServlet.doPost - Starting game service...");
        var result = this.gameService.makeGuess(secret, attempts, status, guess);

        // 결과를 속성으로 설정
        log.info("NumberBaseballGuessServlet.doPost - Setting attributes and redirecting...");
        session.setAttribute("status", result.status());

        // 이미 객체가 있지만, 명시적으로 다시 설정
        session.setAttribute("attempts", result.attempts());
        session.setAttribute("attemptCount", result.attempts().size());

        // Redirect to the guess page to display results
        log.info("NumberBaseballGuessServlet.doPost - Redirecting to guess page...");
        response.sendRedirect(request.getContextPath() + "/num-baseball/guess");
    }
}

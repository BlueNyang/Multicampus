package kr.bluenyang.webgame.game.numbb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballTryVo;
import kr.bluenyang.webgame.game.numbb.service.NumberBaseballGameService;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballStatus;
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

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var dispatcher = request.getRequestDispatcher("/WEB-INF/views/num-baseball/play.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            log.error("Error forwarding to play.jsp: ", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An internal error occurred.");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Processing a guess in Number Baseball Game");
        // session object
        var session = request.getSession();

        // get game objects from session
        @SuppressWarnings("unchecked")
        var secret = (List<Integer>) session.getAttribute("secret");
        @SuppressWarnings("unchecked")
        var attempts = (List<NumberBaseballTryVo>) session.getAttribute("attempts");
        var status = (NumberBaseballStatus) session.getAttribute("status");

        if (secret == null) {
            log.info("Secret number not found in session. Redirecting to start a new game.");
            response.sendRedirect(request.getContextPath() + "/num-baseball/start");
            return;
        }
        if (attempts == null) {
            attempts = new ArrayList<>();
        }

        var guess = request.getParameter("guess");
        if (guess == null || guess.isBlank()) {
            log.info("No guess provided. Redirecting back to guess page.");
            response.sendRedirect(request.getContextPath() + "/num-baseball/guess");
            return;
        }

        log.info("Starting game service...");
        var game = new NumberBaseballGameService(secret, attempts, status);

        var result = game.makeGuess(guess);

        log.info("Setting attributes and redirecting...");
        // 결과를 속성으로 설정
        session.setAttribute("status", result.status());

        // 이미 객체가 있지만, 명시적으로 다시 설정
        session.setAttribute("attempts", result.attempts());
        session.setAttribute("attemptCount", result.attempts().size());

        log.info("Redirecting to guess page...");
        response.sendRedirect(request.getContextPath() + "/num-baseball/guess");
    }
}

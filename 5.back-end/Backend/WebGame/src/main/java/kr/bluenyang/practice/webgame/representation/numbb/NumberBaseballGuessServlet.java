package kr.bluenyang.practice.webgame.representation.numbb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.webgame.domain.numbb.NumberBaseballGame;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/num-baseball/guess")
public class NumberBaseballGuessServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        var session = request.getSession();
        var game = (NumberBaseballGame) session.getAttribute("game");

        if (game == null) {
            response.sendRedirect(request.getContextPath() + "/num-baseball/start");
            return;
        }

        var guess = request.getParameter("guess");
        if (guess == null || guess.isBlank()) {
            response.sendRedirect(request.getContextPath() + "/num-baseball/play.jsp");
            return;
        }

        var result = game.makeGuess(guess);

        // 결과를 속성으로 설정
        session.setAttribute("result", result);

        // 이미 객체가 있지만, 명시적으로 다시 설정
        session.setAttribute("game", game);
        response.sendRedirect(request.getContextPath() + "/num-baseball/play.jsp");
    }
}

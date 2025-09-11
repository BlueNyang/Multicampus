package kr.bluenyang.practice.webgame.representation.hangman;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.webgame.domain.hangman.HangmanGame;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/hangman/guess")
public class HangmanGuessServlet extends HttpServlet {
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
        var game = (HangmanGame) session.getAttribute("hangmanGame");

        if (game == null) {
            response.sendRedirect(request.getContextPath() + "/hangman/start");
            return;
        }

        var guess = request.getParameter("guessInput").charAt(0);

        var result = game.guessLetter(guess);
        // 결과를 속성으로 설정
        session.setAttribute("result", result);
        // 이미 객체가 있지만, 명시적으로 다시 설정
        session.setAttribute("hangmanGame", game);
        response.sendRedirect(request.getContextPath() + "/hangman/play.jsp");
    }
}

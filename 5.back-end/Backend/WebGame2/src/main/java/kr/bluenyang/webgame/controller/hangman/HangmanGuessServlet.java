package kr.bluenyang.webgame.controller.hangman;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.domain.hangman.SecretWord;
import kr.bluenyang.webgame.dto.hangman.HangmanDTO;
import kr.bluenyang.webgame.dto.hangman.HangmanGameInfo;
import kr.bluenyang.webgame.service.hangman.HangmanGameService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serial;

@Slf4j
@WebServlet("/hangman/guess")
public class HangmanGuessServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        log.info("Serving Hangman game play page");
        // 게임 플레이 페이지로 포워드
        try {
            request.getRequestDispatcher("/WEB-INF/views/hangman/play.jsp").forward(request, response);
        } catch (Exception e) {
            log.error("Error forwarding to play.jsp", e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        log.info("Processing guess in Hangman game");

        // 세션 객체
        var session = request.getSession();

        // 세션에서 게임 정보와 단어를 가져옴
        var secretWord = (SecretWord) session.getAttribute("secretWord");
        var game = (HangmanDTO) session.getAttribute("hangmanGame");

        // 게임이 없으면 시작 페이지로 리다이렉트
        if (game == null) {
            log.info("Game not found, redirecting to start page");
            response.sendRedirect(request.getContextPath() + "/hangman/start");
            return;
        }
        log.info("Got secret word and game successfully");

        // 게임 서비스 객체 생성
        var gameService = new HangmanGameService(new HangmanGameInfo(secretWord, game));
        log.info("Created HangmanGameService");

        // 사용자가 입력한 문자 가져오기
        var guess = request.getParameter("guessInput").charAt(0);
        // 문자 추측 처리
        var result = gameService.guessLetter(guess);

        // 이미 객체가 있지만, 명시적으로 다시 설정
        session.setAttribute("hangmanGame", result.dto());
        // 결과를 속성으로 설정
        session.setAttribute("result", result.hangmanGameResult());
        log.info("Updated game state in session");
        // 게임 플레이 페이지로 리다이렉트
        try {
            response.sendRedirect("/WebGame2/hangman/guess");
        } catch (Exception e) {
            log.error("Error redirecting to play.jsp", e);
        }
    }
}

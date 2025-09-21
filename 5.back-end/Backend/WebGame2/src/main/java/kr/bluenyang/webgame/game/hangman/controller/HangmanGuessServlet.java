package kr.bluenyang.webgame.game.hangman.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.game.hangman.model.SecretWordVO;
import kr.bluenyang.webgame.game.hangman.dto.HangmanDTO;
import kr.bluenyang.webgame.game.hangman.dto.HangmanGameInfo;
import kr.bluenyang.webgame.game.hangman.service.HangmanGameService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serial;

@Slf4j
@WebServlet("/hangman/guess")
public class HangmanGuessServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    // 유연성, 테이스 용이성, 유지보수성을 위해 interface로 선언
    private HangmanGameService gameService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 이걸 ServletContext에서 Singleton 객체로 가져옴
        this.gameService = (HangmanGameService) config.getServletContext().getAttribute("hangmanGameService");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        log.info("Processing guess in Hangman game");

        // 세션 객체
        var session = request.getSession();

        // 세션에서 게임 정보와 단어를 가져옴
        var secretWord = (SecretWordVO) session.getAttribute("secretWord");
        var game = (HangmanDTO) session.getAttribute("hangmanGame");

        // 게임이 없으면 시작 페이지로 리다이렉트
        if (game == null) {
            log.info("Game not found, redirecting to start page");
            response.sendRedirect(request.getContextPath() + "/hangman/start");
            return;
        }
        log.info("Got secret word and game successfully");

        // 게임 서비스 객체 생성
        log.info("Created HangmanGameService");

        // 사용자가 입력한 문자 가져오기
        var guess = request.getParameter("guessInput").charAt(0);
        // 문자 추측 처리
        var result = this.gameService.guessLetter(new HangmanGameInfo(secretWord, game), guess);

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

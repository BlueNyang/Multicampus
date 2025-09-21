package kr.bluenyang.webgame.controller.hangman;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.service.hangman.HangmanGameService;
import kr.bluenyang.webgame.service.hangman.HangmanGameStatus;
import kr.bluenyang.webgame.service.hangman.HangmanGuessResult;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;

@Slf4j
@WebServlet("/hangman/start")
public class HangmanStartServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    // 왜 인터페이스로 받는가?
    // - DIP(Dependency Inversion Principle, 의존 역전 원칙) 준수
    // - 유연성 증가: 구현체 변경이 용이
    // - 테스트 용이성: Mock 객체 사용 가능
    // - 유지보수성 향상: 코드 변경 최소화
    private HangmanGameService gameService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // ServletContext에서 인스턴슷 가져옴
        // 이거는 Singleton 객체가 됨.
        this.gameService = (HangmanGameService) config.getServletContext().getAttribute("hangmanGameService");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doProcess(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Hangman game start");
        var gameInfo = this.gameService.createNewGame();
        log.info("New game created successfully");

        // Enum은 jstl에서 바로 사용이 안되므로, Map으로 변환
        var statuses = new HashMap<String, HangmanGameStatus>();
        var resultList = new HashMap<String, HangmanGuessResult>();
        for (var status : HangmanGameStatus.values()) {
            statuses.put(status.name(), status);
        }
        for (var result : HangmanGuessResult.values()) {
            resultList.put(result.name(), result);
        }

        // Session 객체
        var session = request.getSession();
        log.info("Session ID: {}", session.getId());

        // 세션에 게임 정보와 단어, Enum 맵을 저장
        session.setAttribute("hangmanGame", gameInfo.dto());
        session.setAttribute("secretWord", gameInfo.secretWord());
        session.setAttribute("statusList", statuses);
        session.setAttribute("resultList", resultList);

        log.info("Hangman game dispatch to play.jsp");
        // 게임 플레이 페이지로 포워드
        var dispatcher = request.getRequestDispatcher("/WEB-INF/views/hangman/play.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            log.error("Error during forwarding: {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }
}
package kr.bluenyang.webgame.controller.hangman;


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

        log.info("Hangman game start");
        var gameInfo = HangmanGameService.createNewGame();

        var statuses = new HashMap<String, HangmanGameStatus>();
        for (var status : HangmanGameStatus.values()) {
            statuses.put(status.name(), status);
        }

        var resultList = new HashMap<String, HangmanGuessResult>();
        for (var result : HangmanGuessResult.values()) {
            resultList.put(result.name(), result);
        }

        var session = request.getSession();
        log.info("Session ID: {}", session.getId());
        session.setAttribute("hangmanGame", gameInfo.dto());
        session.setAttribute("secretWord", gameInfo.secretWord());
        session.setAttribute("statusList", statuses);
        session.setAttribute("resultList", resultList);

        log.info("Hangman game dispatch to play.jsp");
        var dispatcher = request.getRequestDispatcher("/WEB-INF/views/hangman/play.jsp");
        log.info("Dispatcher: {}", dispatcher);
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            log.error("Error during forwarding: {}", e.getMessage());
            throw e; // Rethrow the exception after logging
        }
        log.info("test");
    }
}
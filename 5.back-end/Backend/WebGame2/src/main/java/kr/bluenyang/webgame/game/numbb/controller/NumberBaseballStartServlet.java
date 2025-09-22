package kr.bluenyang.webgame.game.numbb.controller;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballStatus;
import kr.bluenyang.webgame.game.numbb.service.NumberBaseballGameService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;

@Slf4j
@WebServlet("/num-baseball/start")
public class NumberBaseballStartServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private NumberBaseballGameService gameService;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        super.init();
        this.gameService = (NumberBaseballGameService) cfg.getServletContext().
                getAttribute("numberBaseballGameService");
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

    /**
     * Process both GET and POST requests
     */
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("NumberBaseballStartServlet.doProcess - Start a Number Baseball Game");

        // 세션
        var session = request.getSession();

        // create secret number
        var secret = this.gameService.createNewGame(5);
        log.info("NumberBaseballStartServlet.doProcess - Secret number generated successfully");

        var statusList = new HashMap<String, NumberBaseballStatus>();
        for (var status : NumberBaseballStatus.values()) {
            statusList.put(status.name(), status);
        }

        // store secret number in session
        session.setAttribute("secret", secret);
        session.setAttribute("statusList", statusList);
        var dispatcher = request.getRequestDispatcher("/WEB-INF/views/num-baseball/play.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            log.error("NumberBaseballStartServlet.doProcess - Error forwarding to play.jsp: {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An internal error occurred.");
        }
    }
}
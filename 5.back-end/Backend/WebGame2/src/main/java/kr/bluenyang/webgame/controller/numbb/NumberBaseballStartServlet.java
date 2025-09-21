package kr.bluenyang.webgame.controller.numbb;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.webgame.service.numbb.NumberBaseballGameService;
import kr.bluenyang.webgame.service.numbb.NumberBaseballStatus;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;

@Slf4j
@WebServlet("/num-baseball/start")
public class NumberBaseballStartServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

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
        log.info("Start a Number Baseball Game");

        // 세션
        var session = request.getSession();

        // create secret number
        var secret = NumberBaseballGameService.createNewGame(5);
        log.info("Secret number generated successfully");

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
            log.error("Error forwarding to play.jsp: {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An internal error occurred.");
        }
    }
}
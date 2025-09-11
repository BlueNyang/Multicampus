package kr.bluenyang.practice.webgame.representation.numbb;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.webgame.domain.numbb.NumberBaseballGame;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/num-baseball/start")
public class NumberBaseballStartServlet extends HttpServlet {
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
        session.setAttribute("game", new NumberBaseballGame());
        session.setAttribute("result", null);
        request.getRequestDispatcher("/num-baseball/play.jsp").forward(request, response);
    }
}
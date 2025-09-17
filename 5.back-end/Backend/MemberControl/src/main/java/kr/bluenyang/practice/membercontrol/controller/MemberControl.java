package kr.bluenyang.practice.membercontrol.controller;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.membercontrol.command.Command;
import kr.bluenyang.practice.membercontrol.command.product.*;
import kr.bluenyang.practice.membercontrol.command.user.*;

import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

@WebServlet("*.do")
public class MemberControl extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Command> commandMap;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberControl() {
        super();
        commandMap = new HashMap<>();
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        commandMap.put("/member/memberInsert.do", new MemberInsert());
        commandMap.put("/member/memberView.do", new MemberView());
        commandMap.put("/member/memberUpdateGet.do", new MemberUpdateGet());
        commandMap.put("/member/memberUpdateAction.do", new MemberUpdateAction());
        commandMap.put("/member/memberDelete.do", new MemberDelete());

        commandMap.put("/product/productInsert.do", new ProductInsert());
        commandMap.put("/product/productView.do", new ProductView());
        commandMap.put("/product/productUpdateGet.do", new ProductUpdateGet());
        commandMap.put("/product/productUpdateAction.do", new ProductUpdateAction());
        commandMap.put("/product/productDelete.do", new ProductDelete());
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String commandPath = uri.substring(contextPath.length());

        Command command = commandMap.get(commandPath);
        if (command == null) {
            System.out.println("Not Found Command for " + commandPath);
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String viewPage = command.execute(req, resp);
        if (viewPage == null) {
            viewPage = "/index.jsp";
        }

        String redirectPrefix = "redirect:";
        if (viewPage.startsWith(redirectPrefix)) {
            resp.sendRedirect(viewPage.substring(redirectPrefix.length()));
        } else {
            req.getRequestDispatcher(viewPage).forward(req, resp);
        }
    }
}
package com.example.sec03;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/insertMember2")
public class JoinServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("JoinServlet init method called");
    }

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
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String[] interests = request.getParameterValues("interests");
        String interestsStr = (interests != null) ? String.join(", ", interests) : "None";

        out.println("<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset='UTF-8'>"
                + "<title>Insert title here</title>"
                + "<link rel='stylesheet' href='style.css' />"
                + "</head>"
                + "<body>"
        );

        out.println("<h2>Member Join Info</h2> <hr>");
        out.println("<span>Name: " + request.getParameter("name") + "</span><br>");
        out.println("<span>ID: " + request.getParameter("id") + "</span><br>");
        out.println("<span>PW: " + request.getParameter("pw") + "</span><br>");
        out.println("<span>Phone: " + request.getParameter("phonF")
                + "-" + request.getParameter("phonS")
                + "-" + request.getParameter("phonT")
                + "</span><br>"
        );
        out.println("<span>Grade: " + request.getParameter("grade") + "</span><br>");
        out.println("<span>Interests: " + interestsStr + "</span><br>");
        out.println("<span>Department: " + request.getParameter("department") + "</span><br>");
        out.println("</body></html>");
    }
}

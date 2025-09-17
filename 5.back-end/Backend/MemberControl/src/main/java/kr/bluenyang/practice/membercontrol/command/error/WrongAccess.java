package kr.bluenyang.practice.membercontrol.command.error;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.membercontrol.command.Command;

import java.io.IOException;

public class WrongAccess implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        return "/ex/wrongAccess.jsp";
    }
}

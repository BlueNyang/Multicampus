package kr.bluenyang.webgame.common.listener.hangman;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import kr.bluenyang.webgame.game.hangman.service.HangmanGameService;
import kr.bluenyang.webgame.game.hangman.service.HangmanGameServiceImpl;

@WebListener
public class HangmanInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HangmanGameService hgs = new HangmanGameServiceImpl();
        sce.getServletContext().setAttribute("hangmanGameService", hgs);
    }
}

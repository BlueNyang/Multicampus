package kr.bluenyang.webgame.common.listener;

import jakarta.servlet.annotation.WebListener;
import kr.bluenyang.webgame.game.numbb.service.NumberBaseballGameService;
import kr.bluenyang.webgame.game.numbb.service.NumberBaseballGameServiceImpl;

@WebListener
public class NumberBaseballInitializer implements jakarta.servlet.ServletContextListener {
    @Override
    public void contextInitialized(jakarta.servlet.ServletContextEvent sce) {
        NumberBaseballGameService nbgs = new NumberBaseballGameServiceImpl();
        sce.getServletContext().setAttribute("numberBaseballGameService", nbgs);
    }
}

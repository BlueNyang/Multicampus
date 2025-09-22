package kr.bluenyang.webgame.common.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import kr.bluenyang.webgame.game.hangman.service.HangmanGameService;
import kr.bluenyang.webgame.game.hangman.service.HangmanGameServiceImpl;

// Listener를 사용하는 이유
// - Singleton 패턴을 getInstance()로 구현하는 경우, 각 클래스에서는 구현 클래스에 대한 의존성이 생긴다.
// - Listener를 사용하면, 애플리케이션이 시작될 때 한 번만 객체를 생성하고, 이를 ServletContext에 저장하여
//   다른 클래스들이 해당 객체에 접근할 수 있도록 한다.
// - 또한 각 클래스들은 구현체가 아닌 인터페이스에만 의존하게 되어 결합도가 낮아진다.
// - 이를 통해 의존성 주입(Dependency Injection)과 유지보수성을 향상시킬 수 있다.
// - 즉, Listener를 통해 애플리케이션 전반에 걸쳐 공유되는 객체를 효율적으로 관리할 수 있다.
@WebListener
public class HangmanInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Hangman Game Service를 ServletContext에 저장
        HangmanGameService hgs = new HangmanGameServiceImpl();
        sce.getServletContext().setAttribute("hangmanGameService", hgs);
    }
}

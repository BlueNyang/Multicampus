package kr.bluenyang.webgame.common.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import kr.bluenyang.webgame.user.dao.UserDAO;
import kr.bluenyang.webgame.user.dao.UserDAOImpl;
import kr.bluenyang.webgame.user.service.UserService;
import kr.bluenyang.webgame.user.service.UserServiceImpl;
import kr.bluenyang.webgame.common.util.DBConnect;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@WebListener
public class UserInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(jakarta.servlet.ServletContextEvent sce) {
        // DBConnect, UserDAO, UserService 객체 생성
        DBConnect dbConnect = new DBConnect();
        UserDAO userDAO = new UserDAOImpl(dbConnect);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        UserService userService = new UserServiceImpl(userDAO, encoder);

        // 마지막의 UserService 객체만 ServletContext에 저장
        // 이를 통해 다른 클래스들은 DBConnect나 UserDAO에 직접 접근하지 않고
        // UserService 인터페이스에만 의존하게 된다.
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("userService", userService);
    }
}

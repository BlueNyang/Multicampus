package kr.bluenyang.webgame.listener.user;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import kr.bluenyang.webgame.dao.user.UserDAOImpl;
import kr.bluenyang.webgame.service.user.UserService;
import kr.bluenyang.webgame.util.DBConnect;

@WebListener
public class UserInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(jakarta.servlet.ServletContextEvent sce) {
        DBConnect dbConnect = new DBConnect();
        UserDAOImpl userDAO = new UserDAOImpl(dbConnect);
        UserService userService = new UserService(userDAO);

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("userService", userService);
    }
}

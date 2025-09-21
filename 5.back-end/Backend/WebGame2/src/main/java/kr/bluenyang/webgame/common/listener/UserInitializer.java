package kr.bluenyang.webgame.common.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import kr.bluenyang.webgame.user.dao.UserDAO;
import kr.bluenyang.webgame.user.dao.UserDAOImpl;
import kr.bluenyang.webgame.user.service.UserService;
import kr.bluenyang.webgame.user.service.UserServiceImpl;
import kr.bluenyang.webgame.common.util.DBConnect;

@WebListener
public class UserInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(jakarta.servlet.ServletContextEvent sce) {
        DBConnect dbConnect = new DBConnect();
        UserDAO userDAO = new UserDAOImpl(dbConnect);
        UserService userService = new UserServiceImpl(userDAO);

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("userService", userService);
    }
}

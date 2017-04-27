package main.controllers;

import main.model.pojo.User;
import main.services.UserService;
import main.services.UserServiceImpl;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by admin on 21.04.2017.
 */
public class LoginServlet extends HttpServlet {

    static {
        PropertyConfigurator.configure(LoginServlet.class.getClassLoader()
                .getResource("log4j.properties"));
    }

    //private static final Logger logger = Logger.getLogger(LoginServlet.class);

    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("loginError", "");
        req.getRequestDispatcher("login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String servletPath = req.getServletPath();

            User user =userService.auth(login, password);
            if(user != null){
                req.getSession().setAttribute("login", login);
                req.getSession().setAttribute("admin", user.isAdmin());
                try {
                    resp.sendRedirect(req.getContextPath() + "/listBudgets");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                req.getSession().setAttribute("loginError", "Неправильный логин или пароль");
                try {
//                        resp.sendRedirect(req.getContextPath() + "/login");
                    req.getRequestDispatcher( "/login.jsp").forward(req,resp);
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}

package main.controllers;

import main.model.pojo.User;
import main.services.UserService;
import main.services.UserServiceImpl;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by admin on 21.04.2017.
 */
@Controller
public class LoginServlet {

    static {
        PropertyConfigurator.configure(LoginServlet.class.getClassLoader()
                .getResource("log4j.properties"));
    }

    //private static final Logger logger = Logger.getLogger(LoginServlet.class);

    private static UserService userService = new UserServiceImpl();

//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String showLoginPage(HttpServletRequest req) {
//        req.getSession().setAttribute("loginError", "");
//        return "login";
//    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String postLoginPage(HttpServletRequest req, HttpServletResponse resp) {
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//
//        String servletPath = req.getServletPath();
//
//        User user = userService.auth(login, password);
//        if (user != null) {
//            req.getSession().setAttribute("login", login);
//            req.getSession().setAttribute("admin", user.isAdmin());
//
//            return "redirect:BudgetOperationsList";
//        } else {
//            req.getSession().setAttribute("loginError", "Неправильный логин или пароль");
//
//            return "login";
//        }
//    }

    @RequestMapping(value = "/Registration", method = RequestMethod.GET)
    public String getBudgetFormRegistration(HttpServletRequest req) {
        return "Registration";
    }

}

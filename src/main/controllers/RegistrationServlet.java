package main.controllers;

import main.model.pojo.User;
import main.services.BudgetOperationService;
import main.services.BudgetOperationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.services.UserService;
import main.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 26.04.2017.
 */

@Controller
public class RegistrationServlet {

    private static BudgetOperationService budgetOperationService = new BudgetOperationServiceImpl();
    private static UserService userService = new UserServiceImpl();

    @RequestMapping(value = "RegistrationUser", method = RequestMethod.POST)
    public ModelAndView postRegistrationUser(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String servletPath = req.getServletPath();

        addUser(req);
        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("admin", false);

        ModelAndView modelAndView = new ModelAndView("BudgetOperationsList");
        modelAndView.addObject("BudgetOperations", budgetOperationService.getAllBedgetOperations());
        return modelAndView;
    }

    private User addUser(HttpServletRequest req) {

        String login = req.getParameter("login");
        String password = req.getParameter("pass");

        User user = new User(3,
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                login,
                password,
                false
        );
        return  userService.addUser(user);
    }

}



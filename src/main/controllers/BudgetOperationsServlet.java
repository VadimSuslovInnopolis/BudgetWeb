package main.controllers;

import main.model.pojo.BudgetOperation;
import main.model.pojo.User;
import main.services.BudgetOperationService;
import main.services.BudgetOperationServiceImpl;
//import main.services.UserService;
//import main.services.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by admin on 23.04.2017.
 */

@Controller
public class BudgetOperationsServlet extends HttpServlet {
//    private static final Logger LOGGER = Logger.getLogger(StudentServlet.class);
//
    private static BudgetOperationService budgetOperationService = new BudgetOperationServiceImpl();
//    private static UserService userService = new UserServiceImpl();
//
//    private static final long serialVersionUID = 1L;

    @RequestMapping(value = "BudgetOperationsForm/edit", method = RequestMethod.GET)
    public ModelAndView getBudgetFormEdit(@RequestParam ("id") int id) {
        ModelAndView modelAndView = new ModelAndView("BudgetOperationsForm");
        modelAndView.addObject("BudgetOperation", budgetOperationService.get(id));
        return modelAndView;
    }

    @RequestMapping(value = "BudgetOperationsForm/delete", method = RequestMethod.GET)
    public ModelAndView getBudgetFormDelete(@RequestParam ("id") int id) {
        budgetOperationService.delete(id);

        ModelAndView modelAndView = new ModelAndView("BudgetOperationsList");
        modelAndView.addObject("BudgetOperations", budgetOperationService.getAllBedgetOperations());
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String getBudgetFormLogout(HttpServletRequest req) {
        HttpSession session= req.getSession();
        session.invalidate();

        return "login";
    }

    @RequestMapping(value = "BudgetOperationsForm/add", method = RequestMethod.GET)
    public ModelAndView getBudgetFormAdd() {
        ModelAndView modelAndView = new ModelAndView("BudgetOperationsForm");
        modelAndView.addObject("BudgetOperation", budgetOperationService.get(0));
        return modelAndView;
    }

        @RequestMapping(value = "/BudgetOperationsForm/save", method = RequestMethod.POST)
        public ModelAndView postBudgetForm(HttpServletRequest req,
                                           @RequestParam(value = "dateOper") String date ) {
            java.util.Date dateOper = new java.util.Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateOper = formatter.parse(req.getParameter("dateOper"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        budgetOperationService.save(
                Integer.parseInt(req.getParameter("id")),
                11,
                dateOper,
                1,
                Float.parseFloat(req.getParameter("summa")),
                req.getParameter("description"));

        ModelAndView modelAndView = new ModelAndView("BudgetOperationsList");
        modelAndView.addObject("BudgetOperations", budgetOperationService.getAllBedgetOperations());
        return modelAndView;
    }
}


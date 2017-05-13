package main.controllers;

import main.services.BudgetOperationService;
import main.services.BudgetOperationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 07.05.2017.
 */
@Controller
public class BudgetOperationsList {

    private static BudgetOperationService budgetOperationService = new BudgetOperationServiceImpl();

    @RequestMapping(value = "BudgetOperationsList", method = RequestMethod.GET)
    public ModelAndView getBudgetOperations(HttpServletRequest req) {
        Integer id = null;
        ModelAndView modelAndView = new ModelAndView("BudgetOperationsList");
        modelAndView.addObject("BudgetOperations", budgetOperationService.getAllBedgetOperations());
        return modelAndView;
    }
}

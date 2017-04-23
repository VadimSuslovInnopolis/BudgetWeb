package main.controllers;

import main.services.BudgetOperationService;
import main.services.BudgetOperationServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 23.04.2017.
 */
public class BudgetOperationsServlet extends HttpServlet {
//    private static final Logger LOGGER = Logger.getLogger(StudentServlet.class);
//
    private static BudgetOperationService budgetOperationService = new BudgetOperationServiceImpl();
//
//    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
        if (tryParseInt((String) req.getParameter("edit")) ){
            id = Integer.parseInt((String) req.getParameter("edit"));
            req.setAttribute("student", budgetOperationService.get(id));
            getServletContext().getRequestDispatcher("/BudgetOperationsForm.jsp").forward(req, resp);
        } else if (req.getParameter("add") != null) {
            req.setAttribute("BudgetOperation", BudgetOperationService.create());
            getServletContext().getRequestDispatcher("/BudgetOperationsForm.jsp").forward(req, resp);
        } else if (tryParseInt((String) req.getParameter("delete")) ) {
            id = Integer.parseInt((String) req.getParameter("delete"));
            BudgetOperationService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/BudgetOperationss/");
        } else {
            req.setAttribute("BudgetOperationss", BudgetOperationService.getAllStudents());
            getServletContext().getRequestDispatcher("/BudgetOperationsList.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        try {
            Integer id = null;
            if (tryParseInt(req.getParameter("id"))) {
                id = Integer.parseInt(req.getParameter("id"));
            }
            BudgetOperationService.save(
                    id,
                    req.getParameter("name"),
                    Integer.parseInt(req.getParameter("age")),
                    Integer.parseInt(req.getParameter("group_id"))
            );
        } catch (NumberFormatException e) {
            //LOGGER.error("error in parameters");
        }
        resp.sendRedirect(req.getContextPath() + "/budgetoperations/");
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


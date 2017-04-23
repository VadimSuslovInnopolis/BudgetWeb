package main.controllers;

import main.services.BudgetOperationService;
import main.services.BudgetOperationServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
            req.setAttribute("BudgetOperation", budgetOperationService.create());
            getServletContext().getRequestDispatcher("/BudgetOperationsForm.jsp").forward(req, resp);
        } else if (tryParseInt((String) req.getParameter("delete")) ) {
            id = Integer.parseInt((String) req.getParameter("delete"));
            budgetOperationService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/BudgetOperationss/");
        } else {
            req.setAttribute("BudgetOperationss", budgetOperationService.getAllBedgetOperations());
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
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            try {
                budgetOperationService.save(
                        id,
                        Integer.parseInt(req.getParameter("userID")),
                        formatter.parse(req.getParameter("dateOper")),
                        Integer.parseInt(req.getParameter("budget")),
                        Float.parseFloat(req.getParameter("summa")),
                        req.getParameter("description"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
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


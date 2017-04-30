package main.services;

import main.model.dao.BudgetOperationDAO;
import main.model.dao.BudgetOperationDAOImpl;
import main.model.pojo.BudgetOperation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 23.04.2017.
 */
public class BudgetOperationServiceImpl implements BudgetOperationService {

    private static BudgetOperationDAO budgetOperationDAO = new BudgetOperationDAOImpl();

    @Override
    public List<BudgetOperation> getAllBedgetOperations() {
        List<BudgetOperation> budgetOperations = new ArrayList<>();
        budgetOperations.addAll(budgetOperationDAO.getAll());
        return budgetOperations;
    }

    @Override
    public BudgetOperation get(Integer id) {
        //BudgetOperation budgetOperation = new BudgetOperation(id, userID, dateOper, budget, summa, description);
        return budgetOperationDAO.getById(id);
    }

    @Override
    public void delete(int id) {
        //BudgetOperation budgetOperation = new BudgetOperation(id, userID, dateOper, budget, summa, description);
        budgetOperationDAO.delete(id);
    }

    @Override
    public BudgetOperation create() {
        return null;
    }

    @Override
    public void save(int id, int userID, Date dateOper, int budget, Float summa, String description) {
        BudgetOperation budgetOperation = new BudgetOperation(id, userID, dateOper, budget, summa, description);
        if (id > 0) {
            budgetOperationDAO.update(budgetOperation);
        }
            else {
            budgetOperationDAO.insert(budgetOperation);
        }
    }
}

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
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public BudgetOperation create() {
        return null;
    }

    @Override
    public void save(Integer id, Integer userID, Date dateOper, Integer budget, Float summa, String description) {

    }
}

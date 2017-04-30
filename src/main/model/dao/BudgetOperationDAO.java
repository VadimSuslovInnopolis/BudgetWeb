package main.model.dao;

import main.model.pojo.BudgetOperation;

import java.util.List;

/**
 * Created by admin on 23.04.2017.
 */
public interface BudgetOperationDAO {
    public List<BudgetOperation> getAll();
    public BudgetOperation getById(Integer id);
    public void insert(BudgetOperation budgetOperation);
    public void update(BudgetOperation budgetOperation);
    public void delete(int id);
    public BudgetOperation create();
}

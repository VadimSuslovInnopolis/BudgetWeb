package main.services;

import main.model.pojo.BudgetOperation;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 23.04.2017.
 */
public interface BudgetOperationService {
    public List<BudgetOperation> getAllBedgetOperations();

    public BudgetOperation get(Integer id);

    public void delete(int id);

    public BudgetOperation create();

    public void save(int id, int userID, Date dateOper, int budget, Float summa, String description);
}

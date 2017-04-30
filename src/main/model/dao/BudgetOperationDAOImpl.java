package main.model.dao;

import main.model.ConnectionPool;
import main.model.pojo.BudgetOperation;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 23.04.2017.
 */
public class BudgetOperationDAOImpl implements BudgetOperationDAO {

    private static final String SELECT_ALL = "SELECT id, userID, dateOper, bugdet, summa, description FROM BudgetOperations";

    private static final String INSERT_INTO = "INSERT INTO BudgetOperations (userID, dateOper, bugdet, summa, description) VALUES (?, ?, ?,?, ?)";
    private static final String UPDATE_WHERE = "UPDATE BudgetOperations SET userID = ?, dateOper = ?, bugdet = ?, summa = ?, description = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM BudgetOperations WHERE id=?";

    @Override
    public List<BudgetOperation> getAll() {
        List<BudgetOperation> res = new LinkedList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                res.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public BudgetOperation getById(Integer id) {
        BudgetOperation budgetOperation = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(SELECT_ALL + " WHERE id = ?")) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                budgetOperation = createEntity(resultSet);
            }
            else {
                budgetOperation = new BudgetOperation(0, 0,null, 0, 0,"");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return budgetOperation;
    }


    @Override
    public void insert(BudgetOperation budgetOperation) {
        long result = -1;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, budgetOperation.getUserID());
            //statement.setDate(2, (Date) budgetOperation.getDateOper());
            statement.setDate(2, new java.sql.Date( budgetOperation.getDateOper().getTime()));
            statement.setInt(3, budgetOperation.getBudget());
            statement.setFloat(4, budgetOperation.getSumma());
            statement.setString(5, budgetOperation.getDescription());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                result = resultSet.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return result;
    }

    @Override
    public void update(BudgetOperation budgetOperation) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(UPDATE_WHERE)) {
            statement.setInt(1, budgetOperation.getUserID());
            statement.setDate(2, new java.sql.Date( budgetOperation.getDateOper().getTime()));
            statement.setInt(3, budgetOperation.getBudget());
            statement.setFloat(4, budgetOperation.getSumma());
            statement.setString(5, budgetOperation.getDescription());
            statement.setInt(6, budgetOperation.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(DELETE_BY_ID)) {

            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BudgetOperation create() {
        return null;
    }


    private BudgetOperation createEntity(ResultSet resultSet) throws SQLException {
        BudgetOperation budgetOperation = new BudgetOperation(resultSet.getInt("id"), resultSet.getInt("userID"),
                resultSet.getDate("dateOper"), resultSet.getInt("bugdet"), resultSet.getFloat("summa"),
                resultSet.getString("description"));

        return budgetOperation;
    }

}

package main.model.pojo;

import java.util.Date;

/**
 * Created by admin on 23.04.2017.
 */
public class BudgetOperation {
    private int id;
    private int userID;
    private Date dateOper;
    private int budget;
    private float summa;
    private String description;

    public BudgetOperation(int id, int userID, Date dateOper, int budget, float summa, String description) {
        this.id = id;
        this.userID = userID;
        this.dateOper = dateOper;
        this.budget = budget;
        this.summa = summa;
        this.description = description;
    }

    public BudgetOperation() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setDateOper(Date dateOper) {
        this.dateOper = dateOper;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setSumma(float summa) {
        this.summa = summa;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public Date getDateOper() {
        return dateOper;
    }

    public int getBudget() {
        return budget;
    }

    public float getSumma() {
        return summa;
    }

    public String getDescription() {
        return description;
    }
}

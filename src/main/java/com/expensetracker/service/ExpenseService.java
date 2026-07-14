package com.expensetracker.service;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.entity.Expense;

import java.util.List;

public class ExpenseService
{
    private final  ExpenseDAO expenseDAO = new ExpenseDAO();

    public void saveExpense(Expense expense) {
        expenseDAO.saveExpense(expense);
    }

    public Expense getExpenseById(int id) {
        return expenseDAO.getExpenseById(id);
    }

    public List<Expense> getAllExpenses() {
        return expenseDAO.getAllExpenses();
    }

    public void updateExpense(Expense expense) {
        expenseDAO.updateExpense(expense);
    }

    public void deleteExpense(int id) {
        expenseDAO.deleteExpense(id);
    }
}


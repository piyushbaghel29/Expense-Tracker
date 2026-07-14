package com.expensetracker.dao;

import org.hibernate.Session;
import java.util.List;
import com.expensetracker.entity.Expense;
import com.expensetracker.util.HibernateUtil;
import org.hibernate.Transaction;

public class ExpenseDAO {
    public void saveExpense(Expense expense) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(expense);

            transaction.commit();

            System.out.println("Expense Saved Successfully.");

        } catch (Exception e) {

            e.printStackTrace();

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    public Expense getExpenseById(int id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Expense expense = session.get(Expense.class, id);

            return expense;
        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    public List<Expense> getAllExpenses() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Expense> expenses =
                    session.createQuery("FROM Expense", Expense.class)
                            .getResultList();
            return expenses;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    public void updateExpense(Expense expense) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(expense);

            transaction.commit();

            System.out.println("Expense Updated Successfully");
        } catch (Exception e) {

            e.printStackTrace();   // Print the original error first

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void deleteExpense(int id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Expense expense = session.get(Expense.class, id);

            if (expense == null) {
                System.out.println("Expense not found.");
                transaction.rollback();
                return;
            }

            session.remove(expense);
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            }
        }
    }

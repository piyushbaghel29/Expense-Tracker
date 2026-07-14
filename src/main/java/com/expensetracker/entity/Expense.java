package com.expensetracker.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private int expenseId;

    private String title;

    private double amount;

    private String category;

    private LocalDate date;

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Expense() {

    }

    public Expense(int expenseId, String title, double amount, String category, LocalDate date) {
        this.expenseId = expenseId;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;


    }
}

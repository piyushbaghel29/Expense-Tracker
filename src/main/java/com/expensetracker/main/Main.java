package com.expensetracker.main;

import com.expensetracker.entity.Expense;
import com.expensetracker.service.ExpenseService;
import com.expensetracker.util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ExpenseService expenseService = new ExpenseService();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n=================================");
            System.out.println("       Expense Tracker");
            System.out.println("=================================");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Expense By ID");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: {

                    Expense expense = new Expense();

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter Date (yyyy-MM-dd): ");
                    String dateInput = scanner.nextLine();

                    LocalDate date = LocalDate.parse(dateInput);

                    expense.setTitle(title);
                    expense.setAmount(amount);
                    expense.setCategory(category);
                    expense.setDate(date);

                    expenseService.saveExpense(expense);
                    break;
                }

                case 2: {

                    List<Expense> expenses = expenseService.getAllExpenses();

                    if (expenses == null || expenses.isEmpty()) {
                        System.out.println("No Expenses Found.");
                    } else {

                        for (Expense expense : expenses) {
                            printExpense(expense);
                        }
                    }

                    break;
                }

                case 3: {

                    System.out.print("Enter Expense ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Expense expense = expenseService.getExpenseById(id);

                    if (expense != null) {
                        System.out.println("\nExpense Found");
                        printExpense(expense);
                    } else {
                        System.out.println("Expense not found.");
                    }

                    break;
                }

                case 4: {

                    System.out.print("Enter Expense ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Expense expense = expenseService.getExpenseById(id);

                    if (expense == null) {
                        System.out.println("Expense not found.");
                        break;
                    }

                    System.out.println("\nCurrent Expense Details");
                    printExpense(expense);

                    System.out.print("Enter New Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter New Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter New Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter New Date (yyyy-MM-dd): ");
                    String dateInput = scanner.nextLine();

                    LocalDate date = LocalDate.parse(dateInput);

                    expense.setTitle(title);
                    expense.setAmount(amount);
                    expense.setCategory(category);
                    expense.setDate(date);

                    expenseService.updateExpense(expense);

                    break;
                }

                case 5: {

                    System.out.print("Enter Expense ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    expenseService.deleteExpense(id);
                    System.out.println("Expense Deleted Successfully");

                    break;
                }

                case 6: {

                    System.out.println("Thank you for using Expense Tracker!");
                    scanner.close();
                    HibernateUtil.shutdown();
                    return;
                }

                default: {
                    System.out.println("Invalid Choice!");
                }
            }
        }
    }

    private static void printExpense(Expense expense) {

        System.out.println("--------------------------------");
        System.out.println("ID       : " + expense.getExpenseId());
        System.out.println("Title    : " + expense.getTitle());
        System.out.println("Amount   : " + expense.getAmount());
        System.out.println("Category : " + expense.getCategory());
        System.out.println("Date     : " + expense.getDate());
    }
}
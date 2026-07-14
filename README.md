# 💰 Expense Tracker

A console-based Expense Tracker built using **Java**, **Hibernate ORM**, and **PostgreSQL**.

This project demonstrates CRUD operations using the DAO and Service Layer architecture.

---

## 🚀 Features

- ➕ Add Expense
- 📋 View All Expenses
- 🔍 View Expense By ID
- ✏️ Update Expense
- ❌ Delete Expense

---

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-21-orange)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)

---

## 📂 Project Structure

```text
Expense Tracker
│
├── entity
├── dao
├── service
├── util
└── main
```

---

## 🖥️ Application Menu

![Menu](screenshots/menu.png)
---

## ➕ Add Expense

![Add Expense](screenshots/add-expense.png)

---

## 📋 View All Expenses

![View All Expenses](screenshots/view-expense.png)

---

## 🔍 View Expense By ID

![View Expense By ID](screenshots/view-expense-by-id.png)

---

## ✏️ Update Expense

![Update Expense](screenshots/update-expense.png)

---

## ❌ Delete Expense

![Delete Expense](screenshots/delete-expense.png)

---

## 🗄️ PostgreSQL Database

![Database](screenshots/database.png)

---

## 🏗️ Architecture

```text
User
 │
 ▼
Main (Console UI)
 │
 ▼
ExpenseService
 │
 ▼
ExpenseDAO
 │
 ▼
Hibernate ORM
 │
 ▼
PostgreSQL
```

---

## 📚 Concepts Covered

- Java OOP
- Hibernate ORM
- CRUD Operations
- DAO Pattern
- Service Layer
- PostgreSQL
- Transactions
- HQL

---

## ▶️ How to Run

1. Clone the repository.

```bash
git clone https://github.com/piyushbaghel29/Expense-Tracker.git
```

2. Open in IntelliJ IDEA.

3. Configure PostgreSQL credentials in:## Configuration

Update the following properties in `hibernate.cfg.xml` before running the project:

```xml
hibernate.connection.username
hibernate.connection.password
``````

4. Create the database

```sql
CREATE DATABASE expense_tracker;
```

5. Run

```
Main.java
```

---


## 👨‍💻 Author

**Piyush Baghel**

- GitHub: https://github.com/piyushbaghel29
- LinkedIn: https://www.linkedin.com/in/piyush-baghel-1353a620b/
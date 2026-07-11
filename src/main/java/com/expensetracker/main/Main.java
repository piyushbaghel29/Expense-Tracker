package com.expensetracker.main;

import com.expensetracker.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        System.out.println("Hibernate connected successfully");

        HibernateUtil.shutdown();
    }
}
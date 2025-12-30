package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = new Employee(
                "Kshitij",
                "kshitij@gmail.com",
                690000
        );

        session.persist(emp);

        tx.commit();
        session.close();

        System.out.println("Employee inserted successfully!");
    }
}


package com.example.demo;

import com.example.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // One-to-One
        Address addr = new Address();
        addr.setCity("Hyderabad");
        addr.setState("Telangana");

        User user = new User();
        user.setUsername("Sandhya");
        user.setAddress(addr);

        // One-to-Many & Many-to-One
        Department dept = new Department();
        dept.setDeptName("IT");

        Employee emp1 = new Employee();
        emp1.setEmpName("Alice");
        emp1.setDepartment(dept);

        Employee emp2 = new Employee();
        emp2.setEmpName("Bob");
        emp2.setDepartment(dept);

        dept.getEmployees().add(emp1);
        dept.getEmployees().add(emp2);

        // Many-to-Many
        Project proj1 = new Project();
        proj1.setProjectName("Hibernate Migration");

        Project proj2 = new Project();
        proj2.setProjectName("Spring Boot Upgrade");

        emp1.getProjects().add(proj1);
        emp1.getProjects().add(proj2);
        emp2.getProjects().add(proj2);

        session.persist(user);
        session.persist(dept);
        session.persist(emp1);
        session.persist(emp2);

        tx.commit();
        session.close();
        HibernateUtil.shutdown();
    }
}

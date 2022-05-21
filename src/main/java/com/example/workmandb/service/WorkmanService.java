package com.example.workmandb.service;

import com.example.workmandb.model.Workman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkmanService {

    SessionFactory sessionFactory;

    public WorkmanService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Workman> getAllWorkman(){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Workman> listOfWorkman = (List<Workman>) session.createSQLQuery("SELECT * FROM Workman").addEntity(Workman.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return listOfWorkman;
    }
}

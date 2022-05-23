package com.example.workmandb.service;

import com.example.workmandb.model.Workman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkmanService {

    SessionFactory sessionFactory;

    public WorkmanService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Workman> getAllWorkman(){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sqlRequest = "SELECT * FROM Workman";
        List<Workman> listOfWorkman = (List<Workman>) session.createSQLQuery(sqlRequest).addEntity(Workman.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return listOfWorkman;
    }
    @SuppressWarnings("unchecked")
    public List<Workman> getAllMale(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sqlRequest = "SELECT * FROM Workman WHERE gender='Male'";
        List<Workman> listOfMale = (List<Workman>) session.createSQLQuery(sqlRequest).addEntity(Workman.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return listOfMale;
    }
    @SuppressWarnings("unchecked")
    public List<Workman> findByName(String name){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sqlRequest = "SELECT * FROM Workman WHERE first_name = " + "'" + name + "'";
        List<Workman> foundedName = session.createSQLQuery(sqlRequest).addEntity(Workman.class).list();
        session.getTransaction().commit();
        session.close();

        return foundedName;
    }
}

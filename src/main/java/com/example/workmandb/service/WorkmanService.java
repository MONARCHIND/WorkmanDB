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
    public List<Workman> getAllFemale(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sqlRequest = "SELECT * FROM Workman WHERE gender='Female'";
        List<Workman> listOfFemale = (List<Workman>) session.createSQLQuery(sqlRequest).addEntity(Workman.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return listOfFemale;
    }

    @SuppressWarnings("unchecked")
    public List<Workman> findById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sqlRequest = "SELECT * FROM Workman WHERE id = " + "'" + id + "'";
        List<Workman> surnames = session.createSQLQuery(sqlRequest).addEntity(Workman.class).list();
        session.getTransaction().commit();
        session.close();

        return surnames;
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
    @SuppressWarnings("unchecked")
    public List<Workman> findBySurname(String surname){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sqlRequest = "SELECT * FROM Workman WHERE last_name = " + "'" + surname + "'";
        List<Workman> surnames = session.createSQLQuery(sqlRequest).addEntity(Workman.class).list();
        session.getTransaction().commit();
        session.close();

        return surnames;
    }
}

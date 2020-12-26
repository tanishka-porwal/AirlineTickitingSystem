/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.dao;

import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author tanishka
 */
public class DAO {

    private static final Logger log = Logger.getAnonymousLogger();

    private static final ThreadLocal sessionThread = new ThreadLocal();

    private static SessionFactory sessionFactory = new Configuration().configure(new File( "C:\\Users\\tanishka\\Documents\\NetBeansProjects\\FinalProjectWT\\src\\main\\java\\edu\\neu\\hibernate.cfg.xml")).buildSessionFactory();
   

    protected DAO() {
    }

    public static Session getSession() {
        Session session = (Session) DAO.sessionThread.get();

        if (session == null) {
            session = sessionFactory.openSession();
            
            DAO.sessionThread.set(session);
        }
        return session;
    }
    
  

//    private static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            sessionFactory = createSessionFactory();
//              DAO.sessionThread.set(session);
//        }
//        return sessionFactory;
//    }
 


    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Couldn't rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Couldn't close", e);
        }
        DAO.sessionThread.set(null);
    }

    public static void close() {
        getSession().close();
        DAO.sessionThread.set(null);
    }

}

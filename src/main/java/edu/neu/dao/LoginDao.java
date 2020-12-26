/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.dao;

import edu.neu.exception.AddException;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import edu.neu.pojo.User;



/**
 *
 * @author tanishka
 */

public class LoginDao extends DAO {

    public boolean validateAdmin(String username, String password) throws AddException {
        try {
            SQLQuery q = getSession().createSQLQuery("select * from airlineuser where username =:username and password =:password and role ='admin'");
            q.setString("username", username);
            q.setString("password", password);
            Object obj = q.uniqueResult();
            if (obj == null) {
                return false;
            }

        } catch (HibernateException e) {
            rollback();
            throw new AddException("User cannot be found", e);
        } finally {
            close();
        }

        return true;

    }

    public boolean validatePassenger(String username, String password) throws AddException {
        try {

            SQLQuery q = getSession().createSQLQuery(
                    "select * from airlineuser where username=:username and password=:password and role='customer'");
            q.setString("username", username);
            q.setString("password", password);
            Object obj = q.uniqueResult();
            if (obj == null) {
                return false;
            }

        } catch (HibernateException e) {
            rollback();
            throw new AddException("User cannot be found", e);
        } finally {
            close();
        }

        return true;

    }

    public void addUser(String username, String password, String role) throws AddException {

        try {
            begin();
            User u = new User(username, password, role);
            getSession().save(u);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Error while adding user", e);
        } finally {
            close();
        }

    }

    public boolean userPreExists(String username) {
        try {
            begin();
            Query q = getSession().createQuery("From User where username=:username");
            q.setString("username", username);
            List list = q.list();
            commit();

            if (list.size() == 0) {
                return false;
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return false;
        } finally {
            close();
        } return true;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.dao;


import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import edu.neu.exception.AddException;


/**
 *
 * @author tanishka
 */
public class DisplayFlightsDAO extends DAO {

    public List listFlights(String fromPlace, String dest, String deptDate) throws AddException {
        List<String> list = null;

        try {
            begin();
            Query q = getSession().createQuery("from FlightInformation where fromPlace = :fromPlace and dest=:dest");
            q.setString("fromPlace", fromPlace);
            q.setString("dest", dest);

            list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Flight couln't be found", e);
        } finally {
            close();
        }
    }

    public List listAllFlights() throws AddException {

        List<String> list = null;

        try {
            begin();
            Query q = getSession().createQuery("from FlightInformation");
            list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Error while fecthing all flights", e);
        } finally {
            close();
        }

    }

}

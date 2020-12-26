/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import edu.neu.exception.AddException;
import edu.neu.pojo.Airline;


/**
 *
 * @author tanishka
 */

public class AirlineDao extends DAO {

    public Airline create(String airlineName, String owner) throws AddException {
        try {
            begin();
            Airline airplane = new Airline(airlineName, owner);
            getSession().save(airplane);
            commit();
            return airplane;
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Airline couldn't be added", e);
        } finally {
            close();
        }
    }

    public void updateAirplane(Airline airplane) throws AddException {
        try {
            begin();
            getSession().update(airplane);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Airline couldn't be updated", e);
        } finally {
            close();
        }
    }

    public Airline searchAirplaneByID(long airplane_id) throws AddException {
        try {

            begin();
            Query q = getSession().createQuery("from Airline where airplane_id = :airplane_id");
            q.setLong("airplane_id", airplane_id);
            Airline airplane = (Airline) q.uniqueResult();
            commit();
            return airplane;
        } catch (HibernateException e) {
            rollback();
            throw new AddException(
                    "Airplane with following Id couldn'te be found: " + airplane_id + " " + e.getMessage());
        } finally {
            close();
        }
    }

    public int deleteAirplane(long airplane_id) throws AddException {

        try {
            Airline airplane = searchAirplaneByID(airplane_id);

            if (airplane == null) {
                return 0;
            }
            begin();
            getSession().delete(airplane);
            commit();
            return 1;

        } catch (HibernateException e) {
            rollback();
            throw new AddException("Airplane with following Id couldn'te be deleted", e);

        } finally {
            close();
        }

    }
}
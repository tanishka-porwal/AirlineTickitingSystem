/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.dao;

import java.util.List;

import edu.neu.exception.AddException;
import edu.neu.pojo.PaymentProcessor;
import edu.neu.pojo.Traveller;

import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author tanishka
 */
public class TravellerDAO extends DAO {

    public Traveller createTraveller(String firstName, String lastName, String gender, String email, String dob,
            String phonenum, String address) throws AddException {
        try {
            begin();
            Traveller passenger = new Traveller(firstName, lastName, gender, email, dob, phonenum, address);
            getSession().save(passenger);
            commit();
            return passenger;
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Exception while creating new passenger: " + e.getMessage());
        } finally {
            close();
        }

    }

    public PaymentProcessor createPaymentProcessor(long creditCardNumber, String bankName, String fullName,
            String expiration_month, String expiration_year) throws AddException {
        try {
            begin();
            PaymentProcessor p = new PaymentProcessor(creditCardNumber, bankName, fullName, expiration_month,
                    expiration_year);
            getSession().save(p);
            commit();
            return p;
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Exception while creating new payment: " + e.getMessage());
        } finally {
            close();
        }

    }

    public void updateTraveller(long passenger_id, PaymentProcessor payment) throws AddException {

        try {
            begin();
            Query query = getSession().createQuery("From Traveller where passenger_id=:passenger_id ");
            query.setLong("passenger_id", passenger_id);
            Traveller passenger = (Traveller) query.uniqueResult();
            passenger.setPaymentProcessor(payment);
            getSession().update(passenger);
            commit();

        } catch (HibernateException e) {
            rollback();
            throw new AddException("Exception while updating passenger: " + e.getMessage());
        } finally {
            close();
        }
    }

    public Traveller searchTraveller(long passenger_id) throws AddException {
        Traveller passenger;
        try {
            begin();
            Query query = getSession().createQuery("From Traveller where passenger_id=:passenger_id ");
            query.setLong("passenger_id", passenger_id);
            passenger = (Traveller) query.uniqueResult();

            commit();
        } catch (HibernateException e) {
            rollback();
            // throw new AdException("Could not create flight", e);
            throw new AddException("Exception while searching passenger: " + e.getMessage());
        } finally {
            close();
        }
        return passenger;
    }

    public List ListTravellers() throws AddException {
        try {
            begin();
            Query q = getSession().createQuery("From Traveller");
            List list = q.list();
            commit();
            return list;

        } catch (HibernateException e) {
            rollback();
            throw new AddException("Exception while listing passenger: " + e.getMessage());
        } finally {
            close();
        }

    }
}

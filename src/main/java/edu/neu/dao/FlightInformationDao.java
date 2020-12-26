/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import edu.neu.exception.AddException;
import edu.neu.pojo.Destinations;
import edu.neu.pojo.FlightInformation;



/**
 *
 * @author tanishka
 */
public class FlightInformationDao extends DAO {

    public FlightInformation createFlight(long airplane_id, String from, String dest, String deptTime,
            String arrivalTime, String travelClass, int totalSeats, int amount, String deptDate, String arrDate,
            String flight_name, int availableSeats) throws AddException {
        try {
            begin();
            FlightInformation fd = new FlightInformation(airplane_id, from, dest, deptTime, arrivalTime, travelClass,
                    totalSeats, amount, deptDate, arrDate, flight_name, availableSeats);
            getSession().save(fd);
            commit();
            System.out.println("Added flight and available seats are" + fd.getAvailableSeats());
            return fd;
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Exception while creating new flight: " + e.getMessage());
        } finally {
            close();
        }
    }

    public List listFlights() throws AddException {
        try {
            begin();
            Query q = getSession().createQuery("from FlightInformation");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Error while listing all flights", e);
        } finally {
            close();
        }
    }

    public List listCities(String cityname) throws AddException {
        try {
            begin();
            System.out.println("checking here");
            Criteria city = getSession().createCriteria(Destinations.class);
            city.add(Restrictions.ilike("destinationname", cityname, MatchMode.ANYWHERE));
            List list = city.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AddException(e.getMessage());
        } finally {
            close();
        }
    }

    public FlightInformation searchFlightByID(long flight_id) throws AddException {
        try {

            begin();
            Query q = getSession().createQuery("from FlightInformation where flight_id = :flight_id");
            q.setLong("flight_id", flight_id);
            FlightInformation fd = (FlightInformation) q.uniqueResult();
            System.out.println("DAO available seats" + fd.getAvailableSeats());
            System.out.println("More Information" + fd.getFlight_name() + fd.getFlight_id());
            commit();
            return fd;
        } catch (HibernateException e) {
            rollback();
            throw new AddException(
                    "Error while obtaining the flight details with following Id: " + flight_id + " " + e.getMessage());
        } finally {
            close();
        }

    }

    public void deleteFlight(FlightInformation flight) throws AddException {
        try {
            begin();
            getSession().delete(flight);
            commit();
            getSession().flush();
            getSession().clear();
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Could not delete flight", e);
        } finally {
            close();
        }
    }

    public void updateFlight(FlightInformation flight) throws AddException {
        try {
            begin();
            getSession().update(flight);
            commit();
            getSession().flush();
            getSession().clear();

        } catch (HibernateException e) {
            rollback();
            throw new AddException(e.getMessage());
        } finally {
            close();
        }
    }

    public void updateAvailableSeats(FlightInformation flight, int oldTotal, int newTotal) throws AddException {
        try {
            begin();

            int oldAvail = flight.getAvailableSeats();
            System.out.println("Old Seats available are" + flight.getAvailableSeats());
            flight.setAvailableSeats(newTotal - (oldTotal - oldAvail));
            System.out.println("Available seats are " + flight.getAvailableSeats());

            getSession().update(flight);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Could not update flight", e);
        } finally {
            close();
        }
    }

    public void updateSeats(FlightInformation flight, int oldTotal, int newTotal) throws AddException {
        try {
            begin();

            System.out.println("Old Seats available are" + flight.getAvailableSeats());
            flight.setAvailableSeats(oldTotal - newTotal);
            System.out.println("Available seats are " + flight.getAvailableSeats());

            getSession().update(flight);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AddException("Could not update flight", e);
        } finally {
            close();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tanishka
 */

@Entity
@Table(name = "destinations")
public class Destinations {

    @Id
    @Column(name = "destinationname")
    private String destinationname;

    public Destinations() {

    }

    public String getDestinationname() {
        return destinationname;
    }

    public void setDestinationname(String destinationname) {
        this.destinationname = destinationname;
    }
}

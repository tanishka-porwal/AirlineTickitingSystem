/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.exception;

/**
 *
 * @author tanishka
 */
public class AddException extends Exception {

    public AddException(String message) {
        super(message);
    }

    public AddException(String message, Throwable cause) {
        super(message, cause);
    }

}

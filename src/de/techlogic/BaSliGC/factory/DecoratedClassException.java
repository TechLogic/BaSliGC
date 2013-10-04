/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.factory;

/**
 *
 * @author Nils
 */
public class DecoratedClassException extends Exception {

    /**
     * Creates a new instance of
     * <code>DecoratedClassException</code> without detail message.
     */
    public DecoratedClassException() {
    }

    /**
     * Constructs an instance of
     * <code>DecoratedClassException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public DecoratedClassException(String msg) {
        super(msg);
    }
    
    
    
}

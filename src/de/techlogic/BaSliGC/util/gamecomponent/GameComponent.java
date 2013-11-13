/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util.gamecomponent;

import org.newdawn.slick.Graphics;

/**
 * Contains methods to get and set postion, width and height of the object, also
 * a draw method.
 *
 * @author Nils Heyer
 */
public interface GameComponent {

    /**
     * Return the X coordinate of the object
     *
     * @return X coordinate as a float
     */
    float getX();

    /**
     * Return the Y coordinate of the object
     *
     * @return Y coordinate as a float
     */
    float getY();

    /**
     * Set value of the X coordinate of the object.
     *
     * @param x Value of the X coordinate.
     */
    void setX(float x);

    /**
     * Set value of the Y coordinate of the object.
     *
     * @param y Value of the Y coordinate.
     */
    void setY(float y);

    /**
     * Set the width of the object.
     *
     * @param width Width of the object as a float.
     */
    void setWidth(float width)throws IllegalArgumentException;

    /**
     * Set height of the object.
     *
     * @param height Height of the object as a float.
     */
    void setHeight(float height)throws IllegalArgumentException;

    /**
     * Return the width of the object.
     *
     * @return width of the object
     */
    float getWidth();

    /**
     * Return the height of the object.
     *
     * @return height of the object
     */
    float getHeight();

    /**
     * get the GameComponent which is decoreted with this class.
     *
     * @return GameComponent that is decorated with this class.
     */
    GameComponent getComponent();

    /**
     * Draw method of object.
     */
    void draw(Graphics g);
}

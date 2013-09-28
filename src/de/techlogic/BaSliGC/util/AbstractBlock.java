/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techlogic.BaSliGC.util.gamecomponent.AbstractGameComponent;
import org.newdawn.slick.Image;

/**
 * 
 * An image that the is possible to move on.
 * This implementation is depricated better use a plain image .
 *
 * @author Nils Heyer
 */
public abstract class AbstractBlock extends AbstractGameComponent {

    /**
     * Image that is drawn.
     * 
     */
    protected Image image;

    /**
     * Constructor with the position of the image.
     *
     * @param x X coordinate of the image.
     * @param y Y coordinate of the image.
     */
    public AbstractBlock(float x, float y) {
        super(x, y);
    }

    /**
     * Draw Method of the component. Draws the image at the X and Y position
     * that are given in the constructor.
     */
    @Override
    public void draw() {
        image.draw(getX(), getY());
    }
}

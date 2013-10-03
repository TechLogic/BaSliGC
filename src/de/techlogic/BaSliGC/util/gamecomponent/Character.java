/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util.gamecomponent;

import org.newdawn.slick.Image;

/**
 *
 * @author Nils Heyer
 */
public interface Character extends GameComponent {

    /**
     * Draw the character at the position in the parameters.
     *
     * @param x X coordinate of the character
     * @param y Y coordinate of the character
     */
    void draw(float x, float y);

    /**
     * Default draw method.
     */
    void draw();

    /**
     * Get Image that is activ at the moment.
     *
     * @return Image that is active .
     */
    Image getImage();

    /**
     * Setting back as active postion. Character is looking up and the his back
     * side is shown.
     */
    void setback();

    /**
     * Setting front as active position. Character is looking down and the front
     * side is shown.
     */
    void setfront();

    /**
     * Setting left as active position. Character is looking left and the left
     * side is shown.
     */
    void setleft();

    /**
     * Setting right as active position. Character is looking right and the
     * right side is shown.
     */
    void setright();
}

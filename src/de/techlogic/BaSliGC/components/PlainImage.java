/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.components;

import de.techlogic.BaSliGC.util.gamecomponent.AbstractGameComponent;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * A plain image only with the ability to change position, width and height.
 *
 * @author Nils Heyer
 */
public class PlainImage extends AbstractGameComponent {

    private Image image;

    /**
     * Constructor of the plainImage with the image,its position, width and
     * height
     *
     * @param image The Image that should be shown.
     * @param width The width of object.
     * @param height The height of the object.
     * @param x X coordinate of the image.
     * @param y Y coordinate of the image.
     */
    public PlainImage(Image image, float width, float height, float x, float y) {
        super(x, y, width, height);
        this.image = image;
    }

    /**
     * Draws the image at the X and Y position and the width and height which is
     * set before.
     */
    @Override
    public void draw(Graphics g) {
        image.draw(getX(), getY(), getWidth(), getHeight());
    }

   

    @Override
    public GameComponent getComponent() {
        return this;
    }
}

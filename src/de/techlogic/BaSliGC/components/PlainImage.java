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
    public float getWidth() {
        return super.getWidth(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWidth(float width) {
        super.setWidth(width); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getHeight() {
        return super.getHeight(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHeight(float height) {
        super.setHeight(height); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getX() {
        return super.getX(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setX(float x) {
        super.setX(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getY() {
        return super.getY(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setY(float y) {
        super.setY(y); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GameComponent getComponent() {
        return this;
    }
}

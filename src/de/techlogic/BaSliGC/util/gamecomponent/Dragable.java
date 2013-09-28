/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util.gamecomponent;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

/**
 * Add the ability to drag an object to an AbstractGameComponent.
 *
 * @author Nils Heyer
 */
public class Dragable extends AbstractGameComponent {

    private GameComponent image;
    private boolean dragged;

    /**
     * Constructor of the Dragable needs the component that should the dragable
     * and an input that indicates that something is draged.
     *
     * @param image AbstractGameComponent that should be dragable.
     * @param input Input which is added a MouseListener.
     */
    public Dragable(GameComponent image, Input input) {
        super();
        this.image = image;
        dragged = false;
    }

    @Override
    public float getWidth() {
        return image.getWidth(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWidth(float width) {
        image.setWidth(width); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHeight(float height) {
        image.setHeight(height); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getHeight() {
        return image.getHeight(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getX() {
        return image.getX(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setX(float x) {
        image.setX(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getY() {
        return image.getY(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setY(float y) {
        image.setY(y); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method check if the component is pressed, then changed the dragged value
     * to true.
     */
    public boolean fireIsPressed(int mouseX, int mouseY) {


        if (mouseX >= image.getX() && mouseX <= image.getX() + image.getWidth() && mouseY >= image.getY() && mouseY <= image.getY() + image.getHeight()) {
            dragged = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Set the dragged value back to false if the mouse button is released.
     */
    public void fireIsReleased() {
        if (dragged == true) {
            dragged = false;
        }
    }

    /**
     * Changed the position of the component to the mouse position if the
     * component is dragged.
     */
    public void fireIsDragged(int mouseX, int mouseY) {
        if (dragged == true) {
            setX(mouseX);
            setY(mouseY);
        }
    }

    @Override
    public void draw() {
        image.draw();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techologic.BaSliGC.decorated;

import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;

/**
 * Add the ability to drag an object to an AbstractGameComponent.
 *
 * @author Nils Heyer
 */
public class Dragable extends AbstractDecoratedGameComponent {

    private boolean dragged;

    /**
     * Constructor of the Dragable needs the component that should the dragable
     * and an input that indicates that something is draged.
     *
     * @param component AbstractGameComponent that should be dragable.
     * @param input Input which is added a MouseListener.
     */
    public Dragable(GameComponent component) {
        super(component);
        dragged = false;
    }

    @Override
    public float getWidth() {
        return component.getWidth(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWidth(float width) {
        component.setWidth(width); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHeight(float height) {
        component.setHeight(height); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getHeight() {
        return component.getHeight(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getX() {
        return component.getX(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setX(float x) {
        component.setX(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getY() {
        return component.getY(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setY(float y) {
        component.setY(y); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method check if the component is pressed, then changed the dragged value
     * to true.
     */
    public boolean fireIsPressed(int mouseX, int mouseY) {


        if (mouseX >= component.getX() && mouseX <= component.getX() + component.getWidth() && mouseY >= component.getY() && mouseY <= component.getY() + component.getHeight()) {
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
        component.draw();
    }
}

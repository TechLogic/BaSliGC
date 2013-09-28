/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util.gamecomponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

/**
 * Add the button function to an AbstractGameComponent. An ActionEvent is fired
 * if the left mousebutton clicks on the AbstractGameComponent. Need to
 * implement an
 * {@link  <a href="http://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionListener.html"> ActionListener</a>}
 *
 * @author Nils Heyer
 */
public class Clickable extends AbstractGameComponent {

    private GameComponent image;
    private String Text;
    private ActionListener onClick;

    @Override
    public float getWidth() {
        return image.getWidth(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWidth(float width) {
        image.setWidth(width); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getHeight() {
        return image.getHeight(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHeight(float height) {
        image.setHeight(height); //To change body of generated methods, choose Tools | Templates.
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
     * Constructor of a Clickable Object.
     *
     * @param image AbstracGameComponent that should be clickable
     * @param input The input class which invoke the mouseListener
     */
    public Clickable(GameComponent image, Input input) {
        super();
        this.image = image;

    }

    /**
     * Set of the ActionListener which is invoked if the component is clicked.
     *
     * @param onClick The Implementation of the
     * {@link  <a href="http://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionListener.html"> ActionListener Interface</a>}
     * which should be invoked.
     */
    public void setOnClick(ActionListener onClick) {
        this.onClick = onClick;
    }

    /**
     * Check if the mouse click was on the same the component. If true than a
     * ActionEvent is raised and the ActionListner performe the action which is
     * implementet in it.
     */
    public boolean fireMouseClick(int mouseX, int mouseY) {


        if (mouseX >= getX() && mouseX <= getX() + getWidth() && mouseY >= getY() && mouseY <= getY() + getHeight()) {
            ActionEvent e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Mouse Clicked");

            onClick.actionPerformed(e);
            return true;
        } else {
            return false;
        }



    }

    @Override
    public void draw() {
        image.draw();


    }
}
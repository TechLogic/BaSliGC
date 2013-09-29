/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.technologic.BaSliGC.decorated;

import de.techlogic.BaSliGC.components.MainCharacter;
import de.techlogic.BaSliGC.util.CollisionChecker;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;

/**
 * Make an Component unable to walk on.
 *
 * @author Nils Heyer
 */
public class Solid extends AbstractDecoratedGameComponent{

    
    /**
     * Decorated Constructor
     *
     * @param component The GameComponent that shouldn't be able to walk on for
     * the MainCharacter.
     * @param cc The CollisionChecker to which the Solid object should be added
     * to check if someone is walking on it.
     */
    public Solid(GameComponent component, CollisionChecker cc) {
        super(component);
        cc.addSolid(this);

    }

    /**
     * Checks if the Character try to walk onto a component in it's list.
     *
     * @param c The character which walks.
     * @param changeX The value the X Coordinate changes.
     * @param changeY The value the Y Coordinate changes.
     * @return
     */
    public boolean checkCollision(MainCharacter c, float changeX, float changeY) {
        boolean checkx = ((c.getX() + changeX >= getX()) && (c.getX() + changeX <= getX() + getWidth())) || ((c.getX() + changeX + c.getImage().getWidth() >= getX()) && (c.getX() + changeX + c.getImage().getWidth() <= getX() + getWidth()));
        boolean checky = ((c.getY() + changeY >= getY()) && (c.getY() + changeY <= getY() + getHeight())) || ((c.getY() + changeY + c.getImage().getHeight() >= getY()) && (c.getY() + changeY + c.getImage().getHeight() <= getY() + getHeight()));
        if (checkx == true && checky == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public float getX() {
        return component.getX();
    }

    @Override
    public float getY() {
        return component.getY();
    }

    @Override
    public void setX(float x) {
        component.setX(x);
    }

    @Override
    public void setY(float y) {
        component.setY(y);
    }

    @Override
    public void setWidth(float width) {
        component.setWidth(width);
    }

    @Override
    public void setHeight(float height) {
        component.setHeight(height);
    }

    @Override
    public float getWidth() {
        return component.getWidth();
    }

    @Override
    public float getHeight() {
        return component.getHeight();
    }

    @Override
    public void draw() {
        component.draw();
    }
}

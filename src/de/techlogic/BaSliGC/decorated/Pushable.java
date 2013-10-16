/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.decorated;

import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import de.techlogic.BaSliGC.util.gamecomponent.Character;
import org.newdawn.slick.Graphics;

/**
 *
 * @author nils
 */
public class Pushable implements DecoratedGameComponent {

    GameComponent component;

    public Pushable(GameComponent component) {
        this.component = component;
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
    public void setWidth(float width) throws IllegalArgumentException {
        component.setWidth(width);
    }

    @Override
    public void setHeight(float height) throws IllegalArgumentException {
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
    public GameComponent getComponent() {
        return component;
    }

    @Override
    public void draw(Graphics g) {
        component.draw(g);
    }

    public boolean checkCollision(Character c, float changeX, float changeY) {
        boolean checkx = ((c.getX() + changeX >= getX()) && (c.getX() + changeX <= getX() + getWidth())) || ((c.getX() + changeX + c.getImage().getWidth() >= getX()) && (c.getX() + changeX + c.getImage().getWidth() <= getX() + getWidth()));
        boolean checky = ((c.getY() + changeY >= getY()) && (c.getY() + changeY <= getY() + getHeight())) || ((c.getY() + changeY + c.getImage().getHeight() >= getY()) && (c.getY() + changeY + c.getImage().getHeight() <= getY() + getHeight()));
        if (checkx == true && checky == true) {
            return true;
        } else {
            return false;
        }
    }
}
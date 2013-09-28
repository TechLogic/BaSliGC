/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.components;

import de.techlogic.BaSliGC.util.CollisionChecker;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import de.techlogic.BaSliGC.util.gamecomponent.Solid;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Nils Heyer
 */
public class AbstractGameComponent implements GameComponent {

    protected GameComponent component;

    public AbstractGameComponent(String path, float width, float height, float x, float y) {
        try {
            component = new PlainImage(new Image(path), width, height, x, y);
        } catch (SlickException ex) {
            Logger.getLogger(AbstractGameComponent.class.getName()).log(Level.SEVERE, null, ex);
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

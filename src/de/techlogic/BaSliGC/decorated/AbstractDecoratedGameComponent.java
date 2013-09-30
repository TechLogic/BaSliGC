/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.decorated;

import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;

/**
 *
 * @author Nils
 */
public class AbstractDecoratedGameComponent implements DecoratedGameComponent {

    protected GameComponent component;

    public AbstractDecoratedGameComponent(GameComponent component) {
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

    @Override
    public GameComponent getComponent() {
        return component;
    }
}

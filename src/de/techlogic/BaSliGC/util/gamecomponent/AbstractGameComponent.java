/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util.gamecomponent;

import org.newdawn.slick.Image;

/**
 * Implementation of the GameComponent Interface.
 *
 * @author Nils Heyer
 */
public abstract class AbstractGameComponent implements GameComponent {

    private float x;
    private float y;
    private float width;
    private float height;

    /**
     * Empty constructor nothing is set.
     */
    public AbstractGameComponent() {
    }

    /**
     * Position is set in the constructor.
     *
     * @param x X coordinate of the component.
     * @param y Y coordinate of the component.
     */
    public AbstractGameComponent(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Position, width and height are set in the constructor.
     *
     * @param x X coordinaate of the component.
     * @param y Y coordinate of the component.
     * @param width width of the component.
     * @param height height of the component.
     */
    public AbstractGameComponent(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }
}

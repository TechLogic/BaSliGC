/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.components;

import de.techlogic.BaSliGC.util.gamecomponent.AbstractGameComponent;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

/**
 *
 * @author nils
 */
public class PlainAnimation extends AbstractGameComponent {

    private Animation ani;

    public PlainAnimation(Animation ani, float x, float y) {
        super(x, y);
        this.ani = ani;
    }

    @Override
    public GameComponent getComponent() {
        return this;
    }

    @Override
    public float getHeight() {
        return ani.getHeight(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHeight(float height) throws IllegalArgumentException {
        throw new UnsupportedOperationException("With Animation a set Height isn't possible");
    }

    @Override
    public void setWidth(float width) throws IllegalArgumentException {
        throw new UnsupportedOperationException("With Animation a set Height isn't possible");
    }

    @Override
    public float getWidth() {
        return ani.getWidth(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g) {
        ani.draw(getX(), getY());
    }
    
    
    public void drawStop(){
        ani.stop();
        this.draw(null);
    }

}

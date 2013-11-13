/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techlogic.BaSliGC.util.gamecomponent.AbstractGameComponent;
import de.techlogic.BaSliGC.util.gamecomponent.Character;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Nils Heyer
 */
public abstract class AbstractCharacter extends AbstractGameComponent implements Character {

    /**
     * The image that is drawn at the moment.
     */
    protected GameComponent akt;
    /**
     * Back image of the character.
     */
    protected GameComponent back;
    /**
     * Fronts image of the character.
     */
    protected GameComponent front;
    /**
     * Left image of the character.
     */
    protected GameComponent left;
    /**
     * Right image of the character.
     */
    protected GameComponent right;

    /**
     * Posistion and Images are set in the constructor.
     *
     * @param x X coordinate of the character.
     * @param y Y coordinate of the character.
     * @param front Front image of the charater.
     * @param back Back image of the charater.
     * @param left Left image of the charater.
     * @param right Right image of the charater.s
     */
    public AbstractCharacter(float x, float y, GameComponent front, GameComponent back, GameComponent left, GameComponent right){
        super(x, y);
        this.front = front;
        front.setX(x);
        front.setY(y);
        this.back = back;
        back.setX(x);
        back.setY(y);
        this.left = left;
        left.setX(x);
        left.setY(y);
        this.right = right;
        right.setX(x);
        right.setY(y);
        akt = this.front;
    }

    @Override
    public void draw(Graphics g) {
        akt.setX(getX());
        akt.setY(getY());
        akt.draw(g);
    }
    
    

    @Override
    public GameComponent getImage() {
        return akt;
    }

    @Override
    public void setback() {
        akt = back;
    }

    @Override
    public void setfront() {
        akt = front;
    }

    @Override
    public void setleft() {
        akt = left;
    }

    @Override
    public void setright() {
        akt = right;
    }

    @Override
    public float getHeight() {
       return akt.getHeight();
    }

    @Override
    public float getWidth() {
      return akt.getWidth();
    }

    @Override
    public void setHeight(float height) throws IllegalArgumentException {
        back.setHeight(height);
        front.setHeight(height);
        left.setHeight(height);
        right.setHeight(height);
    }

    @Override
    public void setWidth(float width) throws IllegalArgumentException {
      back.setWidth(width);
      front.setWidth(width);
      left.setWidth(width);
      right.setWidth(width);
    }
    
    
    
    
    
    
}

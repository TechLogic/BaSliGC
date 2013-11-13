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
    private Direction direction;
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
    public AbstractCharacter(float x, float y, GameComponent front, GameComponent back, GameComponent left, GameComponent right) {
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
        direction = Direction.FRONT;
    }

    public AbstractCharacter(float x, float y, float width, float height) throws IllegalArgumentException {
        super(x, y, width, height);
        direction = Direction.FRONT;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void draw(Graphics g) {
        getImage().setX(getX());
        getImage().setY(getY());
        getImage().draw(g);
    }

    @Override
    public GameComponent getImage() {
        switch (direction) {
            case BACK: {
                return back;
            }

            case FRONT: {
                return front;
            }

            case LEFT: {
                return left;
            }
            case RIGHT: {
                return right;
            }

        }
        throw new UnknownError("Direction isn't right");
    }

    @Override
    public void setback() {
        direction = Direction.BACK;
    }

    @Override
    public void setfront() {
        direction = Direction.FRONT;
    }

    @Override
    public void setleft() {
        direction = Direction.LEFT;
    }

    @Override
    public void setright() {
        direction = Direction.RIGHT;
    }

    @Override
    public float getHeight() {
        return super.getHeight();
    }

    @Override
    public float getWidth() {
        return   super.getWidth();
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

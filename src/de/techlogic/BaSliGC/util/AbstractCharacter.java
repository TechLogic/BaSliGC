/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techlogic.BaSliGC.util.gamecomponent.Character;
import de.techlogic.BaSliGC.util.gamecomponent.AbstractGameComponent;
import org.newdawn.slick.Image;

/**
 *
 * @author Nils Heyer
 */
public abstract class AbstractCharacter extends AbstractGameComponent implements Character {

    /**
     * The image that is drawn at the moment.
     */
    protected Image akt;
    /**
     * Back image of the character.
     */
    protected Image back;
    /**
     * Fronts image of the character.
     */
    protected Image front;
    /**
     * Left image of the character.
     */
    protected Image left;
    /**
     * Right image of the character.
     */
    protected Image right;

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
    public AbstractCharacter(float x, float y, Image front, Image back, Image left, Image right) {
        super(x, y);
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
        akt = this.front;
    }

    @Override
    public void draw(float x, float y) {
        setX(x);
        setY(y);
        akt.draw(x, y);
    }

    @Override
    public void draw() {
        akt.draw(getX(), getY());
    }

    @Override
    public Image getImage() {
        return front;
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
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.components;

import de.techlogic.BaSliGC.util.AbstractCharacter;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Implementation of the AbstractCharacter class.
 *
 * @author Nils
 */
public class MainCharacter extends AbstractCharacter {

    /**
     * Constructor of the Character that is controlled by the player.
     *
     * @param x X coordinate of the position of the character
     * @param y Y coordinate of the position of the character
     * @throws SlickException
     */
    public MainCharacter(float x, float y, Image front, Image back, Image left, Image right) throws SlickException {
        super(x, y, new PlainImage(front, front.getWidth(),front.getHeight(), x, y),  new PlainImage(back, back.getWidth(),back.getHeight(), x, y),  new PlainImage(left, left.getWidth(),left.getHeight(), x, y),  new PlainImage(right, right.getWidth(),right.getHeight(), x, y));
    }

    @Override
    public GameComponent getComponent() {
        return this;
    }
}

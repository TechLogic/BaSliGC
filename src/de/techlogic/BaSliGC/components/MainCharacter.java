/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.components;

import de.techlogic.BaSliGC.util.AbstractCharacter;
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
    public MainCharacter(float x, float y) throws SlickException {
        super(x, y, new Image("res/Character.png"), new Image("res/Character_back.png"), new Image("res/Character_left.png"), new Image("res/Character_right.png"));
    }
}

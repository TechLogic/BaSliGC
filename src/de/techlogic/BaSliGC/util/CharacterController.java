/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import de.techlogic.BaSliGC.util.gamecomponent.Character;

/**
 *
 * @author Nils
 */
public class CharacterController {

    private Character character;
    private CollisionChecker collisionChecker;
    private Input input;
    private int upKey;
    private int downKey;
    private int leftKey;
    private int rightKey;

    public CharacterController(Character character, CollisionChecker collisionChecker, Input input) {
        this.character = character;
        this.collisionChecker = collisionChecker;
        this.input = input;
    }

    public void setUpKey(int upKey) {
        this.upKey = upKey;
    }

    public void setDownKey(int downKey) {
        this.downKey = downKey;
    }

    public void setLeftKey(int leftKey) {
        this.leftKey = leftKey;
    }

    public void setRightKey(int rightKey) {
        this.rightKey = rightKey;
    }
    
    
    
    

    public void controlCharacter(int width, int height) {
        if (input.isKeyDown(upKey)) {
            character.setback();

            if (character.getY() >= 40 && collisionChecker.checkCollision(character, 0, -1) == false) {

                character.setY(character.getY() - 1);

            }
        } else {

            if (input.isKeyDown(downKey)) {
                character.setfront();
                if (character.getY() < height - character.getImage().getHeight()- 0.25 * height && collisionChecker.checkCollision(character, 0, 1) == false) {
                    character.setY(character.getY() + 1);
                }
            } else {

                if (input.isKeyDown(leftKey)) {
                    character.setleft();
                    if (character.getX() > 0 && collisionChecker.checkCollision(character, -1, 0) == false) {
                        character.setX(character.getX() - 1);
                    }
                } else {

                    if (input.isKeyDown(rightKey)) {
                        character.setright();
                        if (character.getX() < width - character.getImage().getWidth() && collisionChecker.checkCollision(character, 1, 0) == false) {
                            character.setX(character.getX() + 1);
                        }
                    }
                }
            }
        }
    }
}

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

    public CharacterController(Character character, CollisionChecker collisionChecker, Input input) {
        this.character = character;
        this.collisionChecker = collisionChecker;
        this.input = input;
    }
    
    
    

    public void controlCharacter(int width, int height) {
        if (input.isKeyDown(Input.KEY_W)) {
            character.setback();

            if (character.getY() >= 40 && collisionChecker.checkCollision(character, 0, -1) == false) {

                character.setY(character.getY() - 1);

            }
        } else {

            if (input.isKeyDown(Input.KEY_S)) {
                character.setfront();
                if (character.getY() < height - character.getImage().getHeight() - 0.25 * height && collisionChecker.checkCollision(character, 0, 1) == false) {
                    character.setY(character.getY() + 1);
                }
            } else {

                if (input.isKeyDown(Input.KEY_A)) {
                    character.setleft();
                    if (character.getX() > 0 && collisionChecker.checkCollision(character, -1, 0) == false) {
                        character.setX(character.getX() - 1);
                    }
                } else {

                    if (input.isKeyDown(Input.KEY_D)) {
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

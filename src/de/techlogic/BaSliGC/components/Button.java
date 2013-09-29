/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.components;

import de.techlogic.BaSliGC.decorated.Clickable;
import java.awt.event.ActionListener;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Nils Heyer
 */
public class Button extends Clickable {

   

    public Button(String path, float width, float height, float x, float y) throws SlickException {
        super(new PlainImage(new Image(path), width, height, x, y));
    }
}

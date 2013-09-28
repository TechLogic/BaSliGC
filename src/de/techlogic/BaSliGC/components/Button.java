/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.components;

import de.techlogic.BaSliGC.util.gamecomponent.Clickable;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Nils Heyer
 */
public class Button extends AbstractGameComponent {

    public Button(String path, float width, float height, float x, float y, Input input) {
        super(path, width, height, x, y);
        component = new Clickable(component, input);
    }

    public void addActionListener(ActionListener listener) {
        Clickable c = (Clickable) component;
        c.setOnClick(listener);

    }
    
    public Clickable getClickable(){
        Clickable c = (Clickable) component;
        return c;
        
    }
}

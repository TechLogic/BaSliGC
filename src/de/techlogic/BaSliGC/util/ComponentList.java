/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techlogic.BaSliGC.decorated.Clickable;
import de.techlogic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import org.newdawn.slick.MouseListener;

/**
 *
 * @author Nils
 */
public interface ComponentList<MouseListener> {

    void addClickable(Clickable click);

    void addComponent(GameComponent component);

    void addDragable(Dragable drag);

    void draw();

    MouseListener getMouseListener();
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techlogic.BaSliGC.decorated.Clickable;
import de.techlogic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.decorated.Solid;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import org.newdawn.slick.MouseListener;

/**
 * ComponentList Interface is uses to managed all Game Components in a Game
 *
 * @author Nils
 */
public interface ComponentList<MouseListener> {

    /**
     * adds a new Clickable object to the internal clickable and component list
     *
     * @param click Clickable object that should been addeds
     */
    void addClickable(Clickable click);

    /**
     * adds a new GameComponent to the internal component list
     *
     * @param component
     */
    void addComponent(GameComponent component);

    /**
     * adds a new Dragable object to the internal dragable and component list
     *
     * @param click Dragable object that should been addeds
     */
    void addDragable(Dragable drag);

    /**
     * Draws all GameComponents that are managed by the list
     */
    void draw();

    /**
     * get the MouseListerner that is asingnt to the list This method is needed
     * to add the MouseListener to the input class
     *
     * @return MouseListener of Component List
     */
    MouseListener getMouseListener();

    void removesDragable(Dragable drag);

    void removesComponent(GameComponent component);

    void removesClickable(Clickable click);
}

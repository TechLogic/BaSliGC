/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.factory;

import de.techlogic.BaSliGC.decorated.Clickable;
import de.techlogic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.decorated.Solid;
import de.techlogic.BaSliGC.util.AbstractComponentList;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;

/**
 * creates instances of all GameComponents and secure that they were added to
 * the componentList an to the CollisionChecker.
 *
 * @author Nils
 */
public abstract class AbstractComponentFactory {

    private AbstractComponentList list;

    /**
     * creates an new instance of the the factory
     *
     * @param list ComponentList to that the created object should been added
     * @param checker CollisionChecker tho that the created object should been
     * added
     */
    public AbstractComponentFactory(AbstractComponentList list) {
        this.list = list;
    }

    /**
     * creates a new Clickable component and add it to the Component list.
     *
     * @param component the GameComponent that should been decorated with a
     * Clickable function.
     * @return the new Clickable object
     */
    public Clickable createClickable(GameComponent component) {
        Clickable result = new Clickable(component);
        list.removesComponent(component);
        list.addClickable(result);
        return result;
    }

    /**
     * creates a new Solid component and add it to the Component list and the
     * CollisionChecker.
     *
     * @param component the GameComponent that should been decorated with a
     * Solid function.
     * @return the new Solid object
     */
    public Solid createSolid(GameComponent component) {
        Solid result = new Solid(component);
        list.removesComponent(component);
        list.addComponent(result);
        return result;
    }

    /**
     * creates a new Dragable component and add it to the Component list.
     *
     * @param component the GameComponent that should been decorated with a
     * Dragable function.
     * @return the new Dragable object
     */
    public Dragable createDragable(GameComponent component) {
        Dragable result = new Dragable(component);
        list.removesComponent(component);
        list.addDragable(result);
        return result;
    }
}

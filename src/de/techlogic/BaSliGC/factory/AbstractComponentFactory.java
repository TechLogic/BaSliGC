/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.factory;

import de.techlogic.BaSliGC.decorated.Clickable;
import de.techlogic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.decorated.Solid;
import de.techlogic.BaSliGC.util.CollisionChecker;
import de.techlogic.BaSliGC.util.Slick2dComponentList;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;

/**
 * creates instances of all GameComponents and secure that they were added to
 * the componentList an to the CollisionChecker.
 *
 * @author Nils
 */
public abstract class AbstractComponentFactory {

    private Slick2dComponentList list;
    private CollisionChecker checker;

    /**
     * creates an new instance of the the factory
     *
     * @param list ComponentList to that the created object should been added
     * @param checker CollisionChecker tho that the created object should been
     * added
     */
    public AbstractComponentFactory(Slick2dComponentList list, CollisionChecker checker) {
        this.list = list;
        this.checker = checker;
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
        // component needs to be removed from list before adding it new otherwise it would be rendered twice

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
        checker.addSolid(result);
        // component needs to be removed from list before adding it new otherwise it would be rendered twice
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
        // component needs to be removed from list before adding it new otherwise it would be rendered twice

        list.addDragable(result);
        return result;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.factory;

import de.techlogic.BaSliGC.decorated.Clickable;
import de.techlogic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.decorated.Solid;
import de.techlogic.BaSliGC.util.CollisionChecker;
import de.techlogic.BaSliGC.util.ComponentList;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;

/**
 *
 * @author Nils
 */
public abstract class AbstractComponentFactory {
    
    private ComponentList list;
    private CollisionChecker checker;
    
    public AbstractComponentFactory(ComponentList list, CollisionChecker checker) {
        this.list = list;
        this.checker = checker;
    }
    
    public Clickable createClickable(GameComponent component) {
        Clickable result = new Clickable(component);
        // component needs to be removed from list before adding it new otherwise it would be rendered twice

        list.addClickable(result);
        return result;
    }
    
    public Solid createSolid(GameComponent component) {
        Solid result = new Solid(component);
        checker.addSolid(result);
        // component needs to be removed from list before adding it new otherwise it would be rendered twice
        list.addComponent(result);
        return result;
    }
    
    public Dragable createDragable(GameComponent component) {
        Dragable result = new Dragable(component);
        // component needs to be removed from list before adding it new otherwise it would be rendered twice

        list.addDragable(result);
        return result;
    }
}

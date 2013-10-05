/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techlogic.BaSliGC.decorated.Clickable;
import de.techlogic.BaSliGC.decorated.DecoratedGameComponent;
import de.techlogic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.decorated.Solid;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import de.techlogic.BaSliGC.util.gamecomponent.Character;
import java.util.LinkedList;

/**
 * Abstact implementation of the ComponentList.
 *
 * @author Nils
 */
public abstract class AbstractComponentList<MouseListener> implements ComponentList {

    private MouseListener mouseListener;
    private CollisionChecker collisionChecker;
    private LinkedList<GameComponent> componentList;
    private LinkedList<GameComponent> lastComponent;
    private LinkedList<Dragable> dragableList;
    private LinkedList<Clickable> clickableList;
    private LinkedList<Character> characterList;
    private Dragable active;

    public int getSize() {
        return componentList.size() + characterList.size();
    }

    /**
     * Default constructor creates all internal LinkLists with a dummy head.
     *
     */
    public AbstractComponentList(CollisionChecker collisionChecker) {
        this.collisionChecker = collisionChecker;
        clickableList = new LinkedList();
        dragableList = new LinkedList();
        componentList = new LinkedList();
        characterList = new LinkedList();
        active = null;


    }

    /**
     * sets the internal mouseListener that is need to react to input made by
     * the user. Needs to been callen in the constuctor of child classes
     *
     * @param mouseListener MouseListenerObject that should be attached to the
     * ComponentList
     */
    protected void setMouseListener(MouseListener mouseListener) {
        this.mouseListener = mouseListener;
    }

    boolean contains(GameComponent g) {
        if (componentList.contains(g)) {
            return true;
        } else {
            return false;
        }
    }

    boolean containsClickable(Clickable g) {
        if (clickableList.contains(g)) {
            return true;
        } else {
            return false;
        }
    }

    boolean containsDragable(Dragable g) {
        if (dragableList.contains(g)) {
            return true;
        } else {
            return false;
        }
    }

    boolean containsCharacter(Character g) {
        if (characterList.contains(g)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addClickable(Clickable click) {
        addComponent(click);
        clickableList.add(click);
    }

    @Override
    public void addCharacter(Character character) {
        characterList.add(character);

    }

    @Override
    public void addComponent(GameComponent component) {
        if (component.getClass() == Solid.class) {
            collisionChecker.addSolid((Solid) component);
        }
        componentList.add(component);

    }

    @Override
    public void addDragable(Dragable drag) {
        addComponent(drag);
        dragableList.add(drag);
    }

    public void removesForDecoration(GameComponent component) {
        componentList.remove(component);

    }

    public void removesCharacter(Character character) {
        characterList.remove(character);
    }

    @Override
    public void removesClickable(Clickable click) {
        clickableList.remove(click);
    }

    private void searchforSolid(GameComponent component) {
        if (component.getClass() != DecoratedGameComponent.class) {
        } else {
            if (component.getClass() == Solid.class) {
                collisionChecker.removeSolid((Solid) component);
            } else {
                searchforSolid(component.getComponent());
            }
        }
    }

    @Override
    public void removesComponent(GameComponent component) {
        searchforSolid(component);
        componentList.remove(component);
    }

    @Override
    public void removesDragable(Dragable drag) {
        dragableList.remove(drag);
    }

    @Override
    public void draw() {

        for (GameComponent component : componentList) {
            component.draw();
        }
        for (Character c : characterList) {
            c.draw();
        }
    }

    @Override
    public MouseListener getMouseListener() {
        return mouseListener;
    }

    /**
     * search in the internal list if a clickable object is clicked and fires
     * the Click event of this Clickable. This method should be invoked when a
     * mouse click event occure in the mouseListener.
     *
     * @param x X coordinate of the mousepointer
     * @param y Y coordinate of the mousepointer
     */
    protected void fireClicked(int x, int y) {
        for (Clickable c : clickableList) {
            if (c.fireMouseClick(x, y)) {
                break;
            }
        }
    }

    /**
     * search in the internal list if a Dragable object is press and fires the
     * pressed event of this Dragable. Sets the active object to the found one.
     * This method should be invoked when a mouse click event occure in the
     * mouseListener.
     *
     * @param x X coordinate of the mousepointer
     * @param y Y coordinate of the mousepointer
     */
    protected void firePressed(int x, int y) {
        for (Dragable d : dragableList) {
            if (d.fireIsPressed(x, y)) {
                active = d;
                removesComponent(active);
                addComponent(active);
                break;
            }

        }
    }

    /**
     * fires the realease event of the active object and set the element back to
     * null. This method should be invoked when a mouse released event occure in
     * the mouseListener.
     *
     */
    protected void fireRealesed() {
        if (active != null) {
            active.fireIsReleased();
            active = null;
        }
    }

    /**
     * fires the dragged event of the active object. This method should be
     * invoked when a mouse dragged event occure in the mouseListener.
     *
     * @param newx new X Coordinate of the mousepointer
     * @param newy new Y Coordinate of the mousepointer
     */
    protected void fireDragged(int newx, int newy) {
        if (active != null) {
            active.fireIsDragged(newx, newy);

        }

    }
}

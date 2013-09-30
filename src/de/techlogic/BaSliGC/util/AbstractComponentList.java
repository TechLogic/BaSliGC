/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techlogic.BaSliGC.decorated.Clickable;
import de.techlogic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;

/**
 *
 * @author Nils
 */
public abstract class AbstractComponentList<MouseListener> implements ComponentList {

    private MouseListener mouseListener;
    private ComponentLink<GameComponent> componentList;
    private ComponentLink<Dragable> dragableList;
    private ComponentLink<Clickable> clickableList;
    private Dragable active;

    public AbstractComponentList() {
        clickableList = new ComponentLink(null);
        dragableList = new ComponentLink(null);
        componentList = new ComponentLink(null);
        active = null;
    }

    protected void setMouseListener(MouseListener mouseListener) {
        this.mouseListener = mouseListener;
    }

    @Override
    public void addClickable(Clickable click) {
        addComponent(click);
        ComponentLink<Clickable> link = new ComponentLink(click);
        link.next = clickableList.next;
        clickableList.next = link;
    }

    @Override
    public void addComponent(GameComponent component) {
        ComponentLink<GameComponent> link = new ComponentLink(component);
        link.next = componentList.next;
        componentList.next = link;
    }

    @Override
    public void addDragable(Dragable drag) {
        addComponent(drag);
        ComponentLink<Dragable> link = new ComponentLink(drag);
        link.next = dragableList.next;
        dragableList.next = link;
    }

    @Override
    public void draw() {
        ComponentLink<GameComponent> activeLink = componentList;
        while (activeLink.next != null) {
            activeLink = activeLink.next;
            activeLink.content.draw();
        }
    }

    @Override
    public MouseListener getMouseListener() {
        return mouseListener;
    }

    protected void fireClicked(int x, int y) {
        ComponentLink<Clickable> activeLink = clickableList;
        while (activeLink.next != null) {
            activeLink = activeLink.next;
            if (activeLink.content.fireMouseClick(x, y)) {
                break;
            }
        }
    }

    protected void firePressed(int x, int y) {
        ComponentLink<Dragable> activeLink = dragableList;
        while (activeLink.next != null) {
            activeLink = activeLink.next;
            if (activeLink.content.fireIsPressed(x, y)) {
                active = activeLink.content;
                break;
            }

        }
    }

    protected void fireRealesed() {
        if (active != null) {
            active.fireIsReleased();
            active = null;
        }
    }

    protected void fireDragged(int newx, int newy) {
        if (active != null) {
            active.fireIsDragged(newx, newy);
        }

    }

    private class ComponentLink<T> {

        ComponentLink<T> next;
        T content;

        public ComponentLink(T content) {
            this.content = content;
        }
    }
}

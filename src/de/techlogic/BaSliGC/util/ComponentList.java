/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techologic.BaSliGC.decorated.Clickable;
import de.techologic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

/**
 *
 * @author Nils
 */
public class ComponentList{

    ComponentLink<Dragable> dragableList;
    ComponentLink<Clickable> clickableList;
    ComponentLink<GameComponent> componentList;
    int dragsize;
    int clicksize;
    Dragable active;
    MouseListenerImpl mouseListener;

    public ComponentList() {
        mouseListener = new MouseListenerImpl();
        dragableList = new ComponentLink(null);
        componentList = new ComponentLink(null);
        clickableList = new ComponentLink(null);
        dragsize = 0;
        clicksize = 0;
        active = null;
    }

    public MouseListener getMouseListener() {
        return mouseListener;
    }

    public void addComponent(GameComponent component) {
        ComponentLink<GameComponent> link = new ComponentLink(component);
        link.next = componentList.next;
        componentList.next = link;
    }

    public void addClickable(Clickable click) {
        addComponent(click);
        ComponentLink<Clickable> link = new ComponentLink(click);
        link.next = clickableList.next;
        clickableList.next = link;
    }

    public void addDragable(Dragable drag) {
        addComponent(drag);
        ComponentLink<Dragable> link = new ComponentLink(drag);
        link.next = dragableList.next;
        dragableList.next = link;
    }
    
    public void draw(){
        ComponentLink<GameComponent> activeLink = componentList;
        while(activeLink.next!= null){
            activeLink = activeLink.next;
            activeLink.content.draw();
        }
    }

    private class MouseListenerImpl implements MouseListener {

        @Override
        public void mouseWheelMoved(int change) {
        }

        @Override
        public void mouseClicked(int button, int x, int y, int clickCount) {
            ComponentLink<Clickable> activeLink = clickableList;
            while (activeLink.next != null) {
                activeLink = activeLink.next;
                if (activeLink.content.fireMouseClick(x, y)) {
                    break;
                }
            }
        }

        @Override
        public void mousePressed(int button, int x, int y) {
            ComponentLink<Dragable> activeLink = dragableList;
            while (activeLink.next != null) {
                activeLink = activeLink.next;
                if (activeLink.content.fireIsPressed(x, y)) {
                    active = activeLink.content;
                    break;
                }

            }
        }

        @Override
        public void mouseReleased(int button, int x, int y) {
            if (active != null) {
                active.fireIsReleased();
                active = null;
            }
        }

        @Override
        public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        }

        @Override
        public void mouseDragged(int oldx, int oldy, int newx, int newy) {
            if (active != null) {
                active.fireIsDragged(newx, newy);
            }
        }

        @Override
        public void setInput(Input input) {
        }

        @Override
        public boolean isAcceptingInput() {
            return true;
        }

        @Override
        public void inputEnded() {
        }

        @Override
        public void inputStarted() {
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
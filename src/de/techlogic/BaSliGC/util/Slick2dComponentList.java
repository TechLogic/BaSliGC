/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

/**
 *
 * @author Nils
 */
public class Slick2dComponentList extends AbstractComponentList<MouseListener> {
    
    public Slick2dComponentList(CollisionChecker collisionChecker) {
        super(collisionChecker);
        setMouseListener(new MouseListenerImp());
    }
    
    private class MouseListenerImp implements MouseListener {
        
        @Override
        public void mouseWheelMoved(int change) {
        }
        
        @Override
        public void mouseClicked(int button, int x, int y, int clickCount) {
            fireClicked(x, y);
        }
        
        @Override
        public void mousePressed(int button, int x, int y) {
            firePressed(x, y);
        }
        
        @Override
        public void mouseReleased(int button, int x, int y) {
            fireRealesed();
        }
        
        @Override
        public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        }
        
        @Override
        public void mouseDragged(int oldx, int oldy, int newx, int newy) {
            fireDragged(newx, newy);
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
}
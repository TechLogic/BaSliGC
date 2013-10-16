/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techlogic.BaSliGC.decorated.Pushable;
import de.techlogic.BaSliGC.decorated.Solid;
import de.techlogic.BaSliGC.util.gamecomponent.Character;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import java.util.LinkedList;
import java.util.List;

/**
 *Checks if a character will collide with a solid object.
 * Has a list of solid object .
 * @author Nils Heyer
 */
public class CollisionChecker {

    private List<Solid> solidList;
    private List<Pushable> pushList;

    /**
     * Default Constructor inistalisation of list.
     */
    public CollisionChecker() {
        this.solidList = new LinkedList();
        this.pushList = new LinkedList();

    }

    /**
     *Checks if the character will collide with an object in the list.
     * @param component The character which should has moved
     * @param changeX The value the X Coordinate changes.
     * @param changeY The value the Y Coordinate changes.
     * @return false if the character dosen't hit anything otherwise it will
     * return true.
     */
    public boolean checkCollision(GameComponent component, float changeX, float changeY) {
        for (Pushable push : pushList) {
            if (push.checkCollision(component, changeX, changeY)) {
                if (SolidCollision(push, changeX, changeY)) {
                    return true;
                } else {
                    push.setX(push.getX() + changeX);
                    push.setY(push.getY() + changeY);
                }
            }
        }
        return SolidCollision(component, changeX, changeY);
    }

    private boolean SolidCollision(GameComponent component, float changeX, float changeY) {
        for (Solid solid : solidList) {
            if (solid.checkCollision(component, changeX, changeY)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add a new Solid object to the list.
     *
     * @param solid The oject that should be added.
     */
    public void addSolid(Solid solid) {
        solidList.add(solid);
    }

    /**
     * Removes a Solid oject from the list.
     *
     * @param solid The object that should be removed.
     */
    public void removeSolid(Solid solid) {
        solidList.remove(solid);
    }

    /**
     * Add a new Pushable object to the list.
     *
     * @param pushable The oject that should be added.
     */
    public void addSolid(Pushable pushable) {
        pushList.add(pushable);
    }

    /**
     * Removes a Pushable oject from the list.
     *
     * @param pushable The object that should be removed.
     */
    public void removePushable(Pushable pushable) {
        pushList.remove(pushable);
    }
}

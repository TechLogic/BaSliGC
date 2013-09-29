/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.technologic.BaSliGC.decorated.Solid;
import de.techlogic.BaSliGC.components.MainCharacter;
import java.util.ArrayList;
import java.util.List;

/**
 *Checks if a character will collide with a solid object.
 * Has a list of solid object .
 * @author Nils Heyer
 */
public class CollisionChecker {

    private List<Solid> solidList;

    /**
     * Default Constructor inistalisation of list.
     */
    public CollisionChecker() {
        this.solidList = new ArrayList<Solid>();
    }

    /**
     *Checks if the character will collide with an object in the list.
     * @param character The character which should has moved
     * @param changeX The value the X Coordinate changes.
     * @param changeY The value the Y Coordinate changes.
     * @return false if the character dosen't hit anything otherwise it will
     * return true.
     */
    public boolean checkCollision(MainCharacter character, float changeX, float changeY) {
        for (Solid solid : solidList) {
            if (solid.checkCollision(character, changeX, changeY)) {
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
}

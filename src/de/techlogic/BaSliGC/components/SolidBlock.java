/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.components;

import de.techlogic.BaSliGC.util.CollisionChecker;
import de.techlogic.BaSliGC.util.gamecomponent.Solid;

/**
 *
 * @author Nils Heyer
 */
public class SolidBlock extends AbstractGameComponent {

    private Solid block;

    public SolidBlock(String path, float width, float height, float x, float y, CollisionChecker cc) {
        super(path, width, height, x, y);
        component = new Solid(component, cc);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.components;

import de.techlogic.BaSliGC.util.CollisionChecker;
import de.techlogic.BaSliGC.decorated.Solid;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Nils Heyer
 */
public class SolidBlock extends Solid {

    public SolidBlock(String path, float width, float height, float x, float y) throws SlickException {
        super(new PlainImage(new Image(path), width, height, x, y));
    }
}

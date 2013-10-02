/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techlogic.BaSliGC.components.PlainImage;
import de.techlogic.BaSliGC.decorated.Solid;
import de.techlogic.BaSliGC.factory.AbstractComponentFactory;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Nils
 */
public class AbstractComponentListTest {

    private AbstractComponentList<MouseListener> list;
    private AbstractComponentFactory factory;

    public AbstractComponentListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        list = new AbstractComponentList<MouseListener>() {
        };

        factory = new AbstractComponentFactory(list, new CollisionChecker()) {
        };

    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void testaddComponent() {
        PlainImage image = new PlainImage(null, 100, 100, 1, 1);

        Solid solid = factory.createSolid(image);
        assertTrue(null, list.size == 1);
        factory.createDragable(solid);
        assertTrue(null, list.size == 1);

    }
}
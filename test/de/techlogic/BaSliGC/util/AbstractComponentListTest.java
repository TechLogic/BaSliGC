/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util;

import de.techlogic.BaSliGC.components.PlainImage;
import de.techlogic.BaSliGC.decorated.Clickable;
import de.techlogic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.decorated.Solid;
import de.techlogic.BaSliGC.factory.AbstractComponentFactory;
import de.techlogic.BaSliGC.factory.DecoratedClassException;
import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.MouseListener;

/**
 *
 * @author Nils
 */
public class AbstractComponentListTest {

    private AbstractComponentList<MouseListener> list;
    private AbstractComponentFactory factory;
    private PlainImage image;

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

        list = new AbstractComponentList<MouseListener>(new CollisionChecker()) {
        };

        factory = new AbstractComponentFactory(list) {
        };
        image = new PlainImage(null, 100, 100, 1, 1);

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
    public void testaddDragable() {
        Dragable drag = null;
        try {


            Solid solid = factory.createSolid(image);
            assertTrue("Solid object wasn't created right to the list", list.getSize() == 1);
            drag = factory.createDragable(solid);
            assertTrue("Dragable isn't created rightly / isn't add to list", list.getSize() >= 1);
            assertTrue("Solid object isn't removed from list after decoration", list.getSize() <= 1);

        } catch (DecoratedClassException ex) {
            Logger.getLogger(AbstractComponentListTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("A DecoratedClassException was raised!");
        }

        try {
            factory.createDragable(drag);
            fail("Adding a drag object to another should raise an exception");
        } catch (DecoratedClassException ex) {
            assertTrue("Exception is trown", true);
        }



    }

    @Test
    public void testaddClickable() {
        Clickable click = null;
        try {


            Solid solid = factory.createSolid(image);
            assertTrue("Solid object wasn't created right to the list", list.getSize() == 1);
            click = factory.createClickable(solid);
            assertTrue("Clickable isn't created rightly / isn't add to list", list.getSize() >= 1);
            assertTrue("Solid object isn't removed from list after decoration", list.getSize() <= 1);

        } catch (DecoratedClassException ex) {
            Logger.getLogger(AbstractComponentListTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("A DecoratedClassException was raised!");
        }

        try {
            factory.createClickable(click);
            fail("Adding a clickable object to another should raise an exception");
        } catch (DecoratedClassException ex) {
            assertTrue("Exception is trown", true);
        }

    }

    @Test
    public void testaddSolid() {
        Dragable drag = null;
        Solid solid = null;
        try {


            drag = factory.createDragable(image);
            assertTrue("Dragable object wasn't created right and added to the list", list.getSize() == 1);
            solid = factory.createSolid(drag);
            assertTrue("Solid isn't created rightly / isn't add to list", list.getSize() >= 1);
            assertTrue("Dragable object isn't removed from list after decoration", list.getSize() <= 1);

        } catch (DecoratedClassException ex) {
            Logger.getLogger(AbstractComponentListTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("A DecoratedClassException was raised!");
        }

        try {
            factory.createSolid(solid);
            fail("Adding a solid object to another should raise an exception");
        } catch (DecoratedClassException ex) {
            assertTrue("Exception is trown", true);
        }
    }

    @Test
    public void testCheckForSameType() {
        try {
            GameComponent component = factory.createSolid(image);
            assertTrue("Solid object should be created", list.getSize() == 1);
            component = factory.createDragable(component);
            assertTrue("Dragable object should be created", list.getSize() == 1);
            component = factory.createClickable(component);
            assertTrue("Clickable object should be created", list.getSize() == 1);
            factory.createSolid(component);
            fail("Creation of another solid object should raise an DecoratedClassException");

        } catch (DecoratedClassException ex) {
            assertTrue("Exception is thrown", true);
        }

    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.util.gamecomponent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nils
 */
public class GameComponentTest {

    private GameComponent component;

    public GameComponentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        component = new AbstractGameComponent() {
            @Override
            public GameComponent getComponent() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void draw() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    @After
    public void tearDown() {
        component = null;
    }

    @Test
    public void testSetWidth() {
        try {
            component.setWidth(10);
            assertTrue("Component width should be 10", component.getWidth() == 10);
            component.setWidth(0);
            fail("An IllegalArgumentException should be thrown!");
        } catch (IllegalArgumentException ex) {
            assertTrue("Execption is thrown", true);
        } catch (Throwable ex) {
            fail("Wrong exception is thrown");
        }
    }

    @Test
    public void testSetWidth2() {
        try {
            component.setWidth(-20);
            fail("An IllegalArgumentException should be thrown!");
        } catch (IllegalArgumentException ex) {
            assertTrue("Execption is thrown", true);
        } catch (Throwable ex) {
            fail("Wrong exception is thrown");
        }
    }

    @Test
    public void testSetHeight() {
        try {
            component.setHeight(10);
            assertTrue("Component height should be 10", component.getHeight() == 10);
            component.setHeight(0);
            fail("An IllegalArgumentException should be thrown!");
        } catch (IllegalArgumentException ex) {
            assertTrue("Execption is thrown", true);
        } catch (Throwable ex) {
            fail("Wrong exception is thrown");
        }
    }

    @Test
    public void testSetHeight2() {
        try {
            component.setHeight(-20);
            fail("An IllegalArgumentException should be thrown!");
        } catch (IllegalArgumentException ex) {
            assertTrue("Execption is thrown", true);
        } catch (Throwable ex) {
            fail("Wrong exception is thrown");
        }
    }

    @Test
    public void testConstructor() {
        try {
            new AbstractGameComponent(1, 1, 0, 10) {
                @Override
                public GameComponent getComponent() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void draw() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            fail("An IllegalArgumentException should be thrown!");
        } catch (IllegalArgumentException ex) {
            assertTrue("Execption is thrown", true);
        } catch (Throwable ex) {
            fail("Wrong exception is thrown");
        }
    }

    @Test
    public void testConstructor2() {
        try {
            new AbstractGameComponent(1, 1, -100, 10) {
                @Override
                public GameComponent getComponent() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void draw() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            fail("An IllegalArgumentException should be thrown!");
        } catch (IllegalArgumentException ex) {
            assertTrue("Execption is thrown", true);
        } catch (Throwable ex) {
            fail("Wrong exception is thrown");
        }
    }

    @Test
    public void testConstructor3() {
        try {
            new AbstractGameComponent(1, 1, 10, 0) {
                @Override
                public GameComponent getComponent() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void draw() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            fail("An IllegalArgumentException should be thrown!");
        } catch (IllegalArgumentException ex) {
            assertTrue("Execption is thrown", true);
        } catch (Throwable ex) {
            fail("Wrong exception is thrown");
        }
    }

    @Test
    public void testConstructor4() {
        try {
            new AbstractGameComponent(1, 1, 10, -100) {
                @Override
                public GameComponent getComponent() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void draw() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            fail("An IllegalArgumentException should be thrown!");
        } catch (IllegalArgumentException ex) {
            assertTrue("Execption is thrown", true);
        } catch (Throwable ex) {
            fail("Wrong exception is thrown");
        }
    }

    @Test
    public void testSet() {

        component.setX(10);
        assertTrue("X value should be 10", component.getX() == 10);
        component.setY(10);
        assertTrue("Y value should be 10", component.getY() == 10);

    }
}
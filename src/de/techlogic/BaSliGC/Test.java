/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC;

import de.techlogic.BaSliGC.components.MainCharacter;
import de.techlogic.BaSliGC.components.PlainImage;
import de.techlogic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.decorated.Clickable;
import de.techlogic.BaSliGC.factory.AbstractComponentFactory;
import de.techlogic.BaSliGC.factory.DecoratedClassException;
import de.techlogic.BaSliGC.util.CharacterController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.newdawn.slick.*;
import de.techlogic.BaSliGC.util.CollisionChecker;
import de.techlogic.BaSliGC.util.Slick2dComponentList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.opengl.Texture;

/**
 * Testing and executable class of the game
 *
 * @author Nils Heyer
 */
public class Test extends BasicGame {

    private MainCharacter character;
    private CharacterController chararcterController;
    private Input input;
    private Music music;
    private Sound sound;
    private static AppGameContainer app;
    private AbstractComponentFactory factory;
    private Clickable button;
    private Dragable drag;
    private Slick2dComponentList componentList;
    private CollisionChecker collisionChecker;
    private Texture cloud;

    /**
     * Default constructor components List is created.
     */
    /**
     *
     */
    public Test() {

        super("");
        collisionChecker = new CollisionChecker();
        componentList = new Slick2dComponentList(collisionChecker);
        factory = new AbstractComponentFactory(componentList) {
        };

    }

    /**
     * Initalisation of the game Creating all components that are used in the
     * game
     *
     * @param gc
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc) throws SlickException {
        try {
            input = gc.getInput();
            input.addMouseListener(componentList.getMouseListener());
            character = new MainCharacter(45f, 45f, new Image("res/Character.png"), new Image("res/Character_back.png"), new Image("res/Character_left.png"), new Image("res/Character_right.png"));
            chararcterController = new CharacterController(character, collisionChecker, input);
            chararcterController.setDownKey(input.KEY_S);
            chararcterController.setUpKey(input.KEY_W);
            chararcterController.setLeftKey(input.KEY_A);
            chararcterController.setRightKey(input.KEY_D);

            componentList.addCharacter(character);
            drag = factory.createDragable(factory.createSolid(new PlainImage(new Image("res/Sandstone.png"), 100, 100, 300, 300)));
            button = factory.createClickable(new PlainImage(new Image("res/brick.png"), 30, 30, 100, 100));
            button.setOnClick(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        drag = factory.createDragable(factory.createSolid(new PlainImage(new Image("res/Sandstone.png"), 100, 100, 300, 300)));
                    } catch (SlickException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DecoratedClassException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    componentList.addDragable(drag);
                }
            });
        } catch (DecoratedClassException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Update the gamestate Check wich keys are pressed and control the game
     * logic
     *
     * @param gc
     * @param delta
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            app.exit();
        }

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
        }
        chararcterController.controlCharacter(gc.getWidth(), gc.getHeight());
    }

    /**
     * Drawing of the complete game
     *
     * @param gc
     * @param g
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {

        g.setBackground(new Color(10, 45, 80));
        g.setColor(Color.lightGray);
        g.fillRect(0, (float) (0.75 * gc.getHeight()), (gc.getWidth()), (float) (0.25 * gc.getHeight()));
        g.setColor(Color.black);
        //  g.drawString("This should be an HUD", 300, (float) (0.85 * gc.getHeight()));

        componentList.draw(g);

    }

    /**
     * Method to start the game with all settings in it
     *
     * @param args
     * @throws SlickException
     */
    public static void main(String[] args) throws SlickException {
        app = new AppGameContainer(new Test());
        // app.setDisplayMode(800, 600, false);
        app.setDisplayMode(1024, 768, false);
        // app.setFullscreen(true);
        //app.setVSync(true);
        app.start();




    }
    /**
     * Moves the character if the right key is pressed
     *
     * @param gc
     */
}
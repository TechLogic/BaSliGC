/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC;

import de.techlogic.BaSliGC.components.Button;
import de.techlogic.BaSliGC.components.MainCharacter;
import de.techlogic.BaSliGC.components.PlainImage;
import de.techlogic.BaSliGC.decorated.Dragable;
import de.techlogic.BaSliGC.components.SolidBlock;
import de.techlogic.BaSliGC.decorated.Clickable;
import de.techlogic.BaSliGC.factory.AbstractComponentFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.newdawn.slick.*;
import de.techlogic.BaSliGC.util.CollisionChecker;
import de.techlogic.BaSliGC.util.ComponentList;
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
    private Input input;
    private Music music;
    private Sound sound;
    private static AppGameContainer app;
    private AbstractComponentFactory factory;
    private Clickable button;
    private Dragable drag;
    private ComponentList componentList;
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
        componentList = new ComponentList();
        collisionChecker = new CollisionChecker();
        factory = new AbstractComponentFactory(componentList, collisionChecker) {
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
        input = gc.getInput();
        input.addMouseListener(componentList.getMouseListener());
        character = new MainCharacter(45f, 45f);
        componentList.addComponent(character);
        drag = factory.createDragable(factory.createSolid(new PlainImage(new Image("res/Sandstone.png"), 100, 100, 300, 300)));
        button = factory.createClickable(new PlainImage(new Image("res/brick.png"), 30, 30, 100, 100));
        button.setOnClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    drag = factory.createDragable(factory.createSolid(new PlainImage(new Image("res/Sandstone.png"), 100, 100, 300, 300)));
                } catch (SlickException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }

                componentList.addDragable(drag);
            }
        });
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
        CharacterControl(gc);
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

        componentList.draw();

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
    private void CharacterControl(GameContainer gc) {
        if (input.isKeyDown(Input.KEY_W)) {
            character.setback();

            if (character.getY() >= 40 && collisionChecker.checkCollision(character, 0, -1) == false) {

                character.setY(character.getY() - 1);

            }
        } else {

            if (input.isKeyDown(Input.KEY_S)) {
                character.setfront();
                if (character.getY() < gc.getHeight() - character.getImage().getHeight() - 0.25 * gc.getHeight() && collisionChecker.checkCollision(character, 0, 1) == false) {
                    character.setY(character.getY() + 1);
                }
            } else {

                if (input.isKeyDown(Input.KEY_A)) {
                    character.setleft();
                    if (character.getX() > 0 && collisionChecker.checkCollision(character, -1, 0) == false) {
                        character.setX(character.getX() - 1);
                    }
                } else {

                    if (input.isKeyDown(Input.KEY_D)) {
                        character.setright();
                        if (character.getX() < gc.getWidth() - character.getImage().getWidth() && collisionChecker.checkCollision(character, 1, 0) == false) {
                            character.setX(character.getX() + 1);
                        }
                    }
                }
            }
        }
    }
}
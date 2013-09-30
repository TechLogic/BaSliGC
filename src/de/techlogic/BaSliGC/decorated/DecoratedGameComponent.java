/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.techlogic.BaSliGC.decorated;

import de.techlogic.BaSliGC.util.gamecomponent.GameComponent;

/**
 * Interface of a decorated game component.
 *
 * @author Nils
 */
public interface DecoratedGameComponent extends GameComponent {

    /**
     * get the GameComponent which is decoreted with this class.
     *
     * @return GameComponent that is decorated with this class.
     */
    GameComponent getComponent();
}

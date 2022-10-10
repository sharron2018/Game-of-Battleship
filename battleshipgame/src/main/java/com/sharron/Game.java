package com.sharron;

import com.sharron.model.Player;
import com.sharron.util.PlayerType;
import com.sharron.util.ShipType;

/**
 * Contains one game of Battleship.
 */
public class Game {
    private final Player human;
    private final Player computer;

    /**
     * Instantiates a new game. Creates two objects of the Player class.
     * <p>
     * Note that "false" will result in an automated computer player.
     * "True" will cause that player object to ask for user input
     * during the game.
     */
    public Game() {
        human = new Player("human", PlayerType.HUMAN);
        computer = new Player("computer", PlayerType.COMPUTER);
    }

    /**
     * The two players will begin to play.
     * <p>
     * They will place their ships, and then begin to attack.
     */
    public void play() {

        human.placeShip(ShipType.AIRCRAFT_CARRIER);
        human.displaytoMe();
        human.placeShip(ShipType.BATTLESHIP);
        human.displaytoMe();
        human.placeShip(ShipType.SUBMARINE);
        human.displaytoMe();
        human.placeShip(ShipType.PATROLBOAT);
        human.displaytoMe();

        computer.placeShip(ShipType.AIRCRAFT_CARRIER);
        computer.placeShip(ShipType.BATTLESHIP);
        computer.placeShip(ShipType.SUBMARINE);
        computer.placeShip(ShipType.PATROLBOAT);

        computer.displaytoEnemy();

        while (human.hasLost() == false && computer.hasLost() == false) {
            // human start first
            computer.receiveAttack(human.attack());
            computer.displaytoEnemy();
            if (computer.hasLost()) {
                break;
            }
            human.receiveAttack(computer.attack());
            human.displaytoMe();  // no need to display to computer
            if (human.hasLost()) {
                break;
            }
        }

        if (computer.hasLost()) {
            System.out.println("Computer has lost.");
        }

        if (human.hasLost()) {
            System.out.println("Human has lost.");
        }
    }
}

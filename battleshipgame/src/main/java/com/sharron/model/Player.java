package com.sharron.model;
/**
 * Player class for the game of battleship; holds information for one player.
 * Holds the player's board, fleet, and record of attacks.
 */
import com.sharron.model.ship.Ship;
import com.sharron.util.AttackStrategy;
import com.sharron.util.AttackStrategyFactory;
import com.sharron.util.PlaceShipStrategy;
import com.sharron.util.PlaceShipStrategyFactory;
import com.sharron.util.PlayerType;
import com.sharron.util.ShipType;
import lombok.NonNull;


import static com.sharron.util.Constants.MISS_VAL;

public class Player {
    private boolean isLost;
    private final String playerName;
    private final Board board;
    // user's shipFleet
    private final ShipFleet shipFleet;
    // tracking attack record
    private final AttackRecord record;
    private final PlayerType playerType;
    private final PlaceShipStrategy placeShipStrategy;
    private final AttackStrategy attackStrategy;

    /**
     * Instantiates a new player.
     */
    public Player(String playerName, PlayerType playerType) {
        this.playerName = playerName;

        this.board = new Board();
        this.shipFleet = new ShipFleet();

        this.record = new AttackRecord();
        this.playerType = playerType;
        this.placeShipStrategy = PlaceShipStrategyFactory.getStrategy(playerType);
        this.attackStrategy = AttackStrategyFactory.getStrategy(playerType);
    }

	/**
	 * Places a new ship on the board based on different strategy
	 *
	 * Once proper placement for a ship has been obtained, the ship
	 * will be added to the board and to the player's ShipFleet.
	 *
	 * @param shipType
	 */
    public void placeShip(ShipType shipType) {
        final Ship ship = placeShipStrategy.createAndPlaceShipToBoard(shipType, board);
        shipFleet.registerShip(ship);
    }

    /**
     * Prints the board to the player.
     */
    public void displaytoMe() {
        board.displaytoMe();
    }

    /**
     * Prints the board to the player's enemy.
     */
    public void displaytoEnemy() {
        board.displaytoEnemy();
    }


    /**
     * Generates coordinates for an attack based on different strategy
     *
     * Once appropriate coordinates have been found, the player will attack,
     * and record this attack in the AttackRecord.
     *
     * @return attackCoordinates An object of the Coordinates class
     * that contains coordinates for an attack.
     */
    public Coordinates attack() {
        System.out.println("It is " + playerName + "'s turn to attack.");
        return attackStrategy.generateAndRecordAttack(record);
    }

	/**
	 * Deals with an attack from the enemy player.
	 * Checks coordinates to see whether there was
	 * a ship at those coordinates.
	 *
	 * @param coordinates coordinates for an attack initiated
	 * by the enemy.
	 */
    public void receiveAttack(@NonNull Coordinates coordinates) {
        int status = board.checkHit(coordinates);
        if (status == MISS_VAL) {
            System.out.println("The attack has missed.");
            board.receiveMiss(coordinates);
        } else {
            System.out.println(playerName + "'s ship has been hit.");
            board.receiveHit(coordinates);
            shipFleet.shipHit(status);
        }
    }

    /**
	 * Checks whether the player has lost.
	 * @return loss Returns true when this player has lost.
	 */
    public boolean hasLost() {
        if (shipFleet.isLost()) {
            isLost = true;
        }
        return isLost;
    }
}

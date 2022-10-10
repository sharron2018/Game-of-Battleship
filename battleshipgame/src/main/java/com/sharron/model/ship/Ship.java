package com.sharron.model.ship;

import com.sharron.util.ShipType;
import lombok.Getter;

/**
 * Holds the information for one ship.
 */

public class Ship {
    @Getter
    private final String shipName;

    @Getter
    private final int shipLen;

    @Getter
    private final int startRow;

    @Getter
    private final int startCol;

    @Getter
    private final ShipType shipType;

    @Getter
    private final boolean isHorizontal;

    // tracking number of hits this current ship taken, when hits == shipLen then its sunk.
    private int hits;

    // if the current ship is sunk
    private boolean sunk = false;

    /**
     * Instantiates a new ship.
     *
     * @param initLength The length of the ship.
     */
    public Ship(String name, int initLength, int startRow, int startCol, ShipType shipType, boolean isHorizontal) {
        this.shipName = name;
        this.shipLen = initLength;
        this.startRow = startRow;
        this.startCol = startCol;
        this.shipType = shipType;
        this.isHorizontal = isHorizontal;
        this.hits = 0;
    }

	/**
	 * Adds one hit to the ship.
	 */
    public void hits() {
        hits++;
    }

	/**
	 * Determines when the ship is sunk.
	 * This is defined by when the number of hits
	 * it has sustained is equivalent to its length.
	 *
	 * @return sunk Returns true if the ship has been sunk.
	 */
    public boolean isSunk() {
        if (hits == shipLen) {
            sunk = true;
        }
        return sunk;
    }
}

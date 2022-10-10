package com.sharron.model;

import com.sharron.model.ship.Ship;
import com.sharron.util.ShipType;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains the list of ships for one player.
 */
public class ShipFleet {
  // key: shipName
	private final Map<String, Ship> shipMap;

	// track the number of ship has sunk. if sunkShipNumber == shipMap.size() means all ship sunk.
	private int totalSunkShipNumber = 0;

	/**
	 * Instantiates a new ShipFleet.
	 *
	 * Creates four new ships: an aircraft carrier, a battleship,
	 *  a submarine, and a patrol boat.
	 */
	public ShipFleet() {
		this.shipMap = new HashMap<>();
	}

	public void registerShip(Ship ship) {
		if (shipMap.containsKey(ship.getShipName())) {
			throw new RuntimeException("duplicate ship entered!");
		}
		shipMap.put(ship.getShipName(), ship);
	}

	/**
	 * Adds one hit to a designated ship.
	 *
	 * @param shipValue An integer designating which ship has been hit.
	 */
	public void shipHit(int shipValue) {
		final ShipType shipType = ShipType.getShipTypeByValue(shipValue);
		if (!shipMap.containsKey(shipType.getShipName())) {
			throw new RuntimeException("invalid ship");
		}
		final Ship ship = shipMap.get(shipType.getShipName());
		ship.hits();
		totalSunkShipNumber += ship.isSunk() ? 1 : 0;
	}

	/**
	 * Detects when the player has lost all ships, and therefore
	 * when the player has lost the game.
	 *
	 * @return lost Returns true when the player has lost.
	 */
	public boolean isLost() {
		return totalSunkShipNumber == shipMap.size();
	}
}

package com.sharron.util;

import com.sharron.model.ship.AircraftCarrier;
import com.sharron.model.ship.BattleShip;
import com.sharron.model.ship.PatrolBoat;
import com.sharron.model.ship.Ship;
import com.sharron.model.ship.Submarine;

// simple factory to create ship
public class SimpleShipFactory {
    public static Ship createShipByType(ShipType shipType, int startRow, int startCol, boolean isHorizontal) {
        switch (shipType) {
            case AIRCRAFT_CARRIER:
                return new AircraftCarrier(startRow, startCol, shipType, isHorizontal);
            case BATTLESHIP:
                return new BattleShip(startRow, startCol, shipType, isHorizontal);
            case SUBMARINE:
                return new Submarine(startRow, startCol, shipType, isHorizontal);
            case PATROLBOAT:
                return new PatrolBoat(startRow, startCol, shipType, isHorizontal);
            default:
                throw new IllegalArgumentException("invalid input");
        }
    }
}

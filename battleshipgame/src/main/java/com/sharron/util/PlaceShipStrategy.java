package com.sharron.util;

import com.sharron.model.Board;
import com.sharron.model.ship.Ship;
import lombok.NonNull;

public interface PlaceShipStrategy {
    /**
     * Places a new ship on the board based on different strategy
     * If the player is human, placement input will be checked against
     * the current board to see whether the ship can be placed without
     * running into other ships or off the board.
     *
     * If the player is not human, input will be generated randomly
     * and checked in the same way.
     *
     * @param shipType
     * @param board
     */
    Ship createAndPlaceShipToBoard(@NonNull ShipType shipType, @NonNull Board board);
}

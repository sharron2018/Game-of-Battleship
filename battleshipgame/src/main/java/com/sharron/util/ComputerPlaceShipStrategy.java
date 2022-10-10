package com.sharron.util;

import com.sharron.model.Board;
import com.sharron.model.ship.Ship;
import lombok.NonNull;

import java.util.Random;

public class ComputerPlaceShipStrategy implements PlaceShipStrategy{
    @Override
    public Ship createAndPlaceShipToBoard(ShipType shipType, Board board) {
        final Ship ship = getInputsToCreateShip(shipType, board);
        board.addShipToBoard(ship);
        return ship;
    }

    private Ship getInputsToCreateShip(@NonNull ShipType shipType, @NonNull Board board) {
        int row = 0;
        int col = 0;
        boolean valid = false;
        boolean isHorizontal = false;
        Random random = new Random();
        while (!valid) {
            isHorizontal = random.nextBoolean();
            row = (int) (Math.random() * 10);
            col = (int) (Math.random() * 10);
            valid = board.checkAvailibility(isHorizontal, shipType.getShipLen(), row, col);
        }
        Ship ship = SimpleShipFactory.createShipByType(shipType, row, col, isHorizontal);
        return ship;
    }
}

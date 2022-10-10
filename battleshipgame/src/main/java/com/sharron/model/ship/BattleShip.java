package com.sharron.model.ship;

import com.sharron.util.ShipType;

import static com.sharron.util.Constants.BATTLESHIP_LEN;
import static com.sharron.util.Constants.BATTLESHIP_NAME;

public class BattleShip extends Ship{
    public BattleShip(int startRow, int startCol, ShipType shipType, boolean isHorizontal) {
        super(BATTLESHIP_NAME,BATTLESHIP_LEN, startRow, startCol, shipType, isHorizontal);
    }
}

package com.sharron.model.ship;

import com.sharron.util.ShipType;

import static com.sharron.util.Constants.SUBMARINE_LEN;
import static com.sharron.util.Constants.SUBMARINE_NAME;

public class Submarine extends Ship {
    public Submarine(int startRow, int startCol, ShipType shipType,boolean isHorizontal) {
        super(SUBMARINE_NAME, SUBMARINE_LEN, startRow, startCol, shipType, isHorizontal);
    }
}

package com.sharron.model.ship;

import com.sharron.util.ShipType;

import static com.sharron.util.Constants.PATROL_LEN;
import static com.sharron.util.Constants.PATROL_NAME;

public class PatrolBoat extends Ship{
    public PatrolBoat(int startRow, int startCol, ShipType shipType, boolean isHorizontal) {
        super(PATROL_NAME, PATROL_LEN, startRow, startCol, shipType, isHorizontal);
    }
}

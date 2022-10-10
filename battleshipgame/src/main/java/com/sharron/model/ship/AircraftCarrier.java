package com.sharron.model.ship;

import com.sharron.util.ShipType;

import static com.sharron.util.Constants.AIRCRAFT_CARRIER_NAME;
import static com.sharron.util.Constants.AIRCRAFT_CARRIER_LEN;

public class AircraftCarrier extends Ship{
    public AircraftCarrier(int startRow, int startCol, ShipType shipType, boolean isHorizontal) {
        super(AIRCRAFT_CARRIER_NAME, AIRCRAFT_CARRIER_LEN, startRow, startCol, shipType, isHorizontal);
    }
}

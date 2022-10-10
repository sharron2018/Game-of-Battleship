package com.sharron.util;

import static com.sharron.util.Constants.AIRCRAFT_CARRIER_VAL;
import static com.sharron.util.Constants.BATTLESHIP_VAL;
import static com.sharron.util.Constants.PATROL_VAL;
import static com.sharron.util.Constants.SUBMARINE_VAL;

public class BoardCheckUtils {
    public static boolean isMatchShipValue(int val) {
        if (val == AIRCRAFT_CARRIER_VAL ||
                val == BATTLESHIP_VAL ||
                val == SUBMARINE_VAL ||
                val == PATROL_VAL) {
            return true;
        }
        return false;
    }
}

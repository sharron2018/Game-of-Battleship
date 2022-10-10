package com.sharron.util;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static com.sharron.util.Constants.AIRCRAFT_CARRIER_LEN;
import static com.sharron.util.Constants.AIRCRAFT_CARRIER_NAME;
import static com.sharron.util.Constants.AIRCRAFT_CARRIER_VAL;
import static com.sharron.util.Constants.BATTLESHIP_LEN;
import static com.sharron.util.Constants.BATTLESHIP_NAME;
import static com.sharron.util.Constants.BATTLESHIP_VAL;
import static com.sharron.util.Constants.PATROL_LEN;
import static com.sharron.util.Constants.PATROL_NAME;
import static com.sharron.util.Constants.PATROL_VAL;
import static com.sharron.util.Constants.SUBMARINE_LEN;
import static com.sharron.util.Constants.SUBMARINE_NAME;
import static com.sharron.util.Constants.SUBMARINE_VAL;

public enum ShipType {
    AIRCRAFT_CARRIER(AIRCRAFT_CARRIER_NAME,AIRCRAFT_CARRIER_LEN, AIRCRAFT_CARRIER_VAL),
    BATTLESHIP(BATTLESHIP_NAME,BATTLESHIP_LEN, BATTLESHIP_VAL),
    SUBMARINE(SUBMARINE_NAME, SUBMARINE_LEN, SUBMARINE_VAL),
    PATROLBOAT(PATROL_NAME, PATROL_LEN, PATROL_VAL);


    @Getter
    private final String shipName;

    @Getter
    private final int shipLen;

    @Getter
    private final int defaultValue;

    ShipType(String shipName, int shipLen, int defaultValue) {
        this.shipName = shipName;
        this.shipLen = shipLen;
        this.defaultValue = defaultValue;
    }

    private static Map<String, ShipType> map;
    static {
        map = new HashMap<>();
        for (ShipType shipType : ShipType.values()) {
            map.put(shipType.getShipName(), shipType);
        }
    }

    public static ShipType getShipTypeByValue(int val) {
        ShipType res = null;
        for (ShipType shipType : ShipType.values()) {
            if (shipType.defaultValue == val) {
                res = shipType;
                break;
            }
        }
        if (null == res) {
            throw new RuntimeException("the value passed in is wrong");
        }
        return res;
    }
}

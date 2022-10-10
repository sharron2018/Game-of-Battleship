package com.sharron.util;

import java.util.HashMap;
import java.util.Map;

public class PlaceShipStrategyFactory {
    // cache strategy, no need to return new instance
    private static final Map<String, PlaceShipStrategy> strategies = new HashMap<>();
    static {
        strategies.put(PlayerType.HUMAN.toString(), new HumanPlaceShipStrategy());
        strategies.put(PlayerType.COMPUTER.toString(), new ComputerPlaceShipStrategy());
    }
    public static PlaceShipStrategy getStrategy(PlayerType playerType) {
        return strategies.get(playerType.toString());
    }
}

package com.sharron.util;

import java.util.HashMap;
import java.util.Map;

public class AttackStrategyFactory {
    // cache strategy, no need to return new instance
    private static final Map<String, AttackStrategy> strategies = new HashMap<>();
    static {
        strategies.put(PlayerType.HUMAN.toString(), new HumanAttackStrategy());
        strategies.put(PlayerType.COMPUTER.toString(), new ComputerAttackStrategy());
    }
    public static AttackStrategy getStrategy(PlayerType playerType) {
        return strategies.get(playerType.toString());
    }
}

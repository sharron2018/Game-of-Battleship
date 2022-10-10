package com.sharron.util;

import com.sharron.model.AttackRecord;
import com.sharron.model.Coordinates;
import lombok.NonNull;

public interface AttackStrategy {
    /**
     * Generates coordinates for an attack.
     *
     * If the player is human, input will be checked to make sure those same
     * coordinates have not been attacked already, and if those coordinates are
     * in range of the board.
     *
     * If the player is not human, coordinates will be generated randomly
     * and those will also be checked.
     *
     * Once appropriate coordinates have been found, the player will attack,
     * and record this attack in the AttackRecord.
     *
     * @param record the tracking record of existing attacks from the user
     *
     * @return attackCoordinates An object of the Coordinates class
     * that contains coordinates for an attack.
     */
    Coordinates generateAndRecordAttack(@NonNull AttackRecord record);
}

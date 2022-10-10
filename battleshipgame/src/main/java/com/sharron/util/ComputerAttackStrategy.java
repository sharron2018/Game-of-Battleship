package com.sharron.util;

import com.sharron.model.AttackRecord;
import com.sharron.model.Coordinates;
import lombok.NonNull;

public class ComputerAttackStrategy implements AttackStrategy{

    @Override
    public Coordinates generateAndRecordAttack(@NonNull AttackRecord record) {
        final Coordinates coordinates = generateCoordinates(record);
        record.addAttack(coordinates);
        return coordinates;
    }
    private Coordinates generateCoordinates (@NonNull AttackRecord record) {
        int row = 0;
        int col = 0;
        boolean redundant = true;
        while (redundant) {
            row = (int) (Math.random() * 10);
            col = (int) (Math.random() * 10);
            if (record.isRedundant(row, col) == false) {
                redundant = false;
                break;
            }
        }
        return new Coordinates(row, col);
    }
}

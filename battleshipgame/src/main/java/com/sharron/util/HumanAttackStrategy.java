package com.sharron.util;

import com.sharron.model.AttackRecord;
import com.sharron.model.Coordinates;
import lombok.NonNull;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanAttackStrategy implements AttackStrategy{
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
        Scanner scanner = new Scanner(System.in);
        while (redundant) {
            try {
                System.out.println("Please select a coordinate on the vertical axis to target.");
                //Scanner targetx = new Scanner(System.in);
                row = scanner.nextInt();
                if (row < 0 || row > 9) {
                    InputMismatchException f = new InputMismatchException();
                    throw f;
                }
                System.out.println("Please select a coordinate on the horizontal axis to target.");
                //Scanner targety = new Scanner(System.in);
                col = scanner.nextInt();
                if (col < 0 || col > 9) {
                    InputMismatchException f = new InputMismatchException();
                    throw f;
                }
                if (record.isRedundant(row, col)) {
                    System.out.println("You've already hit there. Please select different coordinates.");
                } else {
                    redundant = false;
                }
            } catch (InputMismatchException f) {
                System.out.println("This is not a valid coordinate. Coordinates must be integers between 0 and 9.");
                redundant = true;
            }
        }
        return new Coordinates(row, col);
    }
}

package com.sharron.util;

import com.sharron.model.Board;
import com.sharron.model.ship.Ship;
import lombok.NonNull;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlaceShipStrategy implements PlaceShipStrategy{

    @Override
    public Ship createAndPlaceShipToBoard(@NonNull ShipType shipType, @NonNull Board board) {
        final Ship ship = getInputsToCreateShip(shipType, board);
        board.addShipToBoard(ship);
        return ship;
    }

    private Ship getInputsToCreateShip(@NonNull ShipType shipType, @NonNull Board board) {
        int row = 0;
        int col = 0;
        boolean valid = false;
        boolean isHorizontal = false;
        while (!valid) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please place your " + shipType.getShipName() + ". This ship is " + shipType.getShipLen()  + " squares long.");
                System.out.println("Should the orientation be: 1 - horizontal, or 2 - vertical?");
                //Scanner orientation = new Scanner(System.in);

                int orientationVal = scanner.nextInt();
                switch (orientationVal) {
                    case 1:
                        isHorizontal = true;
                        break;
                    case 2:
                        isHorizontal = false;
                        break;
                    default:
                        InputMismatchException e = new InputMismatchException();
                        throw e;
                }

                System.out.println("Please name a starting point on the vertical axis.[from 0 -- to 9]");
                //Scanner vertical = new Scanner(System.in);
                row = scanner.nextInt();

                System.out.println("Please name a starting point on the horizontal axis.[from 0 -- to 9]");
                //Scanner horizontal = new Scanner(System.in);
                col = scanner.nextInt();

                valid = board.checkAvailibility(isHorizontal, shipType.getShipLen(), row, col);

                if (valid == false) {
                    System.out.println("There's no place on the board for this ship. Please put it somewhere else.");
                }
            } catch (InputMismatchException e) {
                System.out.println("The information you have input is not valid. Please try again.");
                valid = false;
            }
        }
        Ship ship = SimpleShipFactory.createShipByType(shipType, row, col, isHorizontal);
        return ship;
    }
}

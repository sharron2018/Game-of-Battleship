/**
 * @author Sharron Lang
 * Holds the information for a player's board in the game of Battleship.
 */

package com.sharron.model;

import com.sharron.model.ship.Ship;
import com.sharron.util.BoardCheckUtils;
import static com.sharron.util.Constants.BLANK_STR;
import static com.sharron.util.Constants.HIT_STR;
import static com.sharron.util.Constants.HIT_VAL;
import static com.sharron.util.Constants.MISS_STR;
import static com.sharron.util.Constants.MISS_VAL;
import static com.sharron.util.Constants.NOT_FILL_VAL;
import static com.sharron.util.Constants.SHIP_STR;
import static com.sharron.util.Constants.SPLITTER_STR;

public class Board {
    private final int[][] board;

    /**
     * instantiates a new 10x10 board.
     */
    public Board() {
        board = new int[10][10];
    }

    /**
     * Displays the board to the player.
     * O denotes parts of ships that have not yet been hit.
     * X denotes where ships have been hit.
     * - records enemy misses.
     */
    public void displaytoMe() {
        System.out.println();
        System.out.println("This is your board. O: your ships / X: where ships are hit / -: enemy misses");
        System.out.println("  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        System.out.println("--+---+---+---+---+---+---+---+---+---+---|");
        for (int row = 0; row < board.length; row++) {
            //System.out.print(row + " |");
          System.out.print((char)(row + 'A') + " |");
          for (int col = 0; col < board.length; col++) {
                System.out.print(BLANK_STR);
                final int currVal = board[row][col];

                if (BoardCheckUtils.isMatchShipValue(currVal)) {
                    System.out.print(SHIP_STR);
                } else if (currVal == HIT_VAL) {
                    System.out.print(HIT_STR);  // hit
                } else if (currVal == MISS_VAL) {
                    System.out.print(MISS_STR); // miss
                } else if (currVal == NOT_FILL_VAL) {
                    System.out.print(BLANK_STR);
                } else {
                    throw new RuntimeException("board has unknown value at x=[" + row + "] y=[" + col + "]");
                }

                System.out.print(BLANK_STR);
                System.out.print(SPLITTER_STR);
            }
            System.out.println();
            System.out.println("--+---+---+---+---+---+---+---+---+---+---|");
        }
    }

    /**
     * Displays the board to the enemy.
     * X denotes where the enemy has managed to hit a ship.
     * - denotes where the enemy has hit and missed.
     */
    public void displaytoEnemy() {
        System.out.println("This is the enemy board. X: hits / -: misses");
        System.out.println("  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        System.out.println("--+---+---+---+---+---+---+---+---+---+---|");

        for (int row = 0; row < board.length; row++) {
          //System.out.print(row + " |");
          System.out.print((char)(row + 'A') + " |");
            for (int col = 0; col < board.length; col++) {
                System.out.print(BLANK_STR);
                final int currVal = board[row][col];
                // current player's boat, not display to enemy
                if (currVal == NOT_FILL_VAL ) {
                    System.out.print(BLANK_STR);
                }
                // there is a ship at this place
                if (BoardCheckUtils.isMatchShipValue(currVal)) {
                    System.out.print(BLANK_STR);
                }

                if (board[row][col] == HIT_VAL) {
                    System.out.print(HIT_STR);  // hit
//                    continue;
                }

                if (board[row][col] == MISS_VAL) {
                    System.out.print(MISS_STR);   // miss

                }
                System.out.print(BLANK_STR);
                System.out.print(SPLITTER_STR);
            }
            System.out.println();
            System.out.println("--+---+---+---+---+---+---+---+---+---+---|");
        }
    }

	/**
	 * Checks whether a ship can be placed at specific coordinates.
	 *
	 * @param horizontal Whether the user wants the ship to be horizontal/vertical.
	 * @param length Length of the ship.
	 * @param startx Starting location for the ship on the vertical axis.
	 * @param starty Starting location for the ship on the horizontal axis.
	 *
	 * @return valid Returns true when the ship can be placed, given these specifications.
	 */
    public boolean checkAvailibility(boolean horizontal, int length, int startx, int starty) {
        boolean valid = true;
        try {
            if (horizontal == true) {
                for (int n = 0; n < length; n++) {
                    if (board[startx][starty + n] != 0) {
                        valid = false;
                        break;
                    }
                }
            } else {
                // check vertically
                for (int n = 0; n < length; n++) {
                    if (board[startx + n][starty] != 0) {
                        valid = false;
                        break;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            valid = false;
        }
        return valid;
    }

	/**
	 * Adds a ship to the grid at a specified location.
	 *
	 * @param ship the ship to be added to the board
	 *
	 */
    public void addShipToBoard(Ship ship) {
        try {
            if (ship.isHorizontal() == true) {
                // fill horizontal --->
                for (int i = 0; i < ship.getShipLen(); i++) {
                    board[ship.getStartRow()][ship.getStartCol() + i] = ship.getShipType().getDefaultValue();
                }
            } else {
                // fill vertical
                for (int i = 0; i < ship.getShipLen(); i++) {
                    board[ship.getStartRow() + i][ship.getStartCol()] = ship.getShipType().getDefaultValue();
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

	/**
	 * Checks whether there is a ship at given coordinates.
	 *
	 * @param coordinates Coordinates at which the enemy player has chosen to attack.
	 * @return miss value or the current ship value
	 */
    public int checkHit(Coordinates coordinates) {
        int row = coordinates.getRow();
        int col = coordinates.getCol();
        int currVal = board[row][col];
        if (currVal == NOT_FILL_VAL) {
            return MISS_VAL;
        }
        if (BoardCheckUtils.isMatchShipValue(currVal)) {
            return currVal;
        }
        throw new RuntimeException("invalid value on board");
    }

	/**
	 * Deals with when the player's ship has been hit.
	 *
	 * @param c - Coordinates that have been attacked.
	 */
    public void receiveHit(Coordinates c)
    {
        board[c.getRow()][c.getCol()] = HIT_VAL;
    }

	/**
	 * Deals with when the player's board has been hit, but the
	 * attack has missed a ship.
	 *
	 * @param c - Coordinates that have been attacked.
	 */
    public void receiveMiss(Coordinates c)
    {
        board[c.getRow()][c.getCol()] = MISS_VAL;
    }

}


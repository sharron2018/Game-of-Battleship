package com.sharron.model;


/**
 * Keeps a record of all attacks that a player has made.
 */

public class AttackRecord {
	private boolean[][] record;

	/**
	 * Creates a new AttackRecord.
	 *
	 * The matrix is 10x10.
	 */
	public AttackRecord() {
		record = new boolean[10][10];
	}

	/**
	 * Adds an attack to the array.
	 * The value is changed from false to true.
	 *
	 * @param c Coordinates of the attack.
	 */
	public void addAttack(Coordinates c) {
		record[c.getRow()][c.getCol()] = true;
	}

	/**
	 * Determines whether the attack has already been made.
	 *
	 * @param row The vertical coordinate of the attack.
	 * @param col The horizontal coordinate of the attack.
	 *
	 * @return record[x][y] Returns true if this location
	 * on the grid has already been attacked before.
	 */
	public boolean isRedundant(int row, int col) {
		return record[row][col];
	}

}

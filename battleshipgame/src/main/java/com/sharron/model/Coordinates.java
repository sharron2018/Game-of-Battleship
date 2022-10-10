package com.sharron.model;

import lombok.Value;

/**
 * Holds coordinates for an attack that the player is considering.
 */
@Value
public class Coordinates {
	public final int row;
	public final int col;
	/**
	 * Instantiates new Coordinates
	 * @param row Coordinates for the vertical axis.
	 * @param col Coordinates for the horizontal axis.
	 */
	public Coordinates (int row, int col) {
		this.row = row;
		this.col = col;
	}
}

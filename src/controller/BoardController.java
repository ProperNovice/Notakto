package controller;

import utils.ArrayList;
import board.Board;
import enums.Coordinates;
import enums.Dimensions;

public class BoardController {

	private ArrayList<Board> boardsGame = new ArrayList<>();

	public BoardController() {

		createBoards();

	}

	private void createBoards() {

		double firstX = Coordinates.GAME_FIRST.x();
		double x = firstX;
		double y = Coordinates.GAME_FIRST.y();

		double gap = 3 * Dimensions.BOX.x();
		gap += 2 * Dimensions.GAP_BETWEEN_BOXES.x();
		gap += Dimensions.GAP_BETWEEN_TABLES.x();

		int boardsPlaced = 0;

		for (int counter = 1; counter <= 5; counter++) {

			this.boardsGame.add(new Board(x, y));

			boardsPlaced++;
			x += gap;

			if (boardsPlaced < 3)
				continue;

			boardsPlaced = 0;

			x = firstX;
			y += 3 * Dimensions.BOX.y();
			y += 2 * Dimensions.GAP_BETWEEN_BOXES.y();
			y += Dimensions.GAP_BETWEEN_TABLES.y();

		}

	}

}

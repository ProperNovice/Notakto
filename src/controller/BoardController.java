package controller;

import utils.ArrayList;
import board.Board;
import board.Box;
import enums.Coordinates;
import enums.Dimensions;

public class BoardController {

	private ArrayList<Board> boards = new ArrayList<>();
	private ArrayList<Box> boxes = new ArrayList<>();
	private Box boxLastPlayed = null;

	public BoardController() {

	}

	public void create(int boards) {

		createBoards(boards);
		createBoxes();

	}

	private void createBoards(int boards) {

		double firstX = Coordinates.GAME_FIRST.x();
		double x = firstX;
		double y = Coordinates.GAME_FIRST.y();

		double gap = 3 * Dimensions.BOX.x();
		gap += 2 * Dimensions.GAP_BETWEEN_BOXES.x();
		gap += Dimensions.GAP_BETWEEN_TABLES.x();

		int boardsPlaced = 0;

		for (int counter = 1; counter <= boards; counter++) {

			this.boards.add(new Board(x, y));

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

	private void createBoxes() {

		for (Board board : this.boards)
			this.boxes.addAll(board.getBoxes());

	}

	public void setBoxNonEmpty(Box box) {

		if (this.boxLastPlayed != null)
			this.boxLastPlayed.setColorPreviouslyPlayed();

		box.setNonEmpty();
		box.setColorJustPlayed();
		this.boxes.remove(box);
		this.boxLastPlayed = box;

	}

	public void setBoardInactive(Board board) {

		this.boards.remove(board);

		board.setWinningGroupsColor();
		board.setInactive();

		ArrayList<Box> boxClone = this.boxes.clone();

		for (Box box : boxClone)
			if (box.getBoard().equals(board))
				this.boxes.remove(box);

		this.boxLastPlayed = null;

	}

	public ArrayList<Board> getBoards() {
		return this.boards.clone();
	}

	public ArrayList<Box> getBoxes() {
		return this.boxes.clone();
	}

}

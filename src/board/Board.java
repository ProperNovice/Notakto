package board;

import utils.ArrayList;

public class Board {

	private ArrayList<Box> board = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> winningGroups = new ArrayList<>();

	public Board() {

		createBoard();
		createWinningGroups();

	}

	private void createBoard() {

		for (int counter = 1; counter <= 9; counter++)
			this.board.add(new Box());

	}

	private void createWinningGroups() {

		addWinningGroup(0, 1, 2);
		addWinningGroup(3, 4, 5);
		addWinningGroup(6, 7, 8);
		addWinningGroup(0, 3, 6);
		addWinningGroup(1, 4, 7);
		addWinningGroup(2, 5, 8);
		addWinningGroup(0, 4, 8);
		addWinningGroup(2, 4, 6);

	}

	private void addWinningGroup(int a, int b, int c) {

		ArrayList<Integer> list = new ArrayList<>();

		list.add(a);
		list.add(b);
		list.add(c);

		this.winningGroups.add(list);

	}

	public void print() {

		int printed = 0;

		for (Box box : this.board) {

			if (box.isEmpty())
				System.out.print("-");
			else
				System.out.print("x");

			printed++;

			if (printed < 3)
				continue;

			printed = 0;
			System.out.println();

		}

		System.out.println();

	}

	public void rotate() {

		ArrayList<Box> boardOriginal = this.board.clone();
		this.board.clear();

		this.board.add(boardOriginal.get(6));
		this.board.add(boardOriginal.get(3));
		this.board.add(boardOriginal.get(0));
		this.board.add(boardOriginal.get(7));
		this.board.add(boardOriginal.get(4));
		this.board.add(boardOriginal.get(1));
		this.board.add(boardOriginal.get(8));
		this.board.add(boardOriginal.get(5));
		this.board.add(boardOriginal.get(2));

	}

	public void setNonEmpty(int num) {
		this.board.get(num).setNonEmpty();
	}

}

package controller;

import utils.ArrayList;
import utils.HashMap;
import board.Board;
import enums.Element;

public class BoardPatternsController {

	private HashMap<Board, ArrayList<Element>> boardPatterns = new HashMap<>();

	public BoardPatternsController() {
		createBoardPatterns();
	}

	private void createBoardPatterns() {

		this.boardPatterns.addEntry(new Board(), getElementList(Element.C));
		addBoardPattern(new ArrayList<>(), 0);
		addBoardPattern(new ArrayList<>(), 1);
		addBoardPattern(getElementList(Element.C, Element.C), 4);
		addBoardPattern(getElementList(Element.A, Element.D), 0, 1);
		addBoardPattern(getElementList(Element.B), 0, 2);
		addBoardPattern(getElementList(Element.B), 0, 4);
		addBoardPattern(getElementList(Element.B), 0, 5);
		addBoardPattern(getElementList(Element.A), 0, 8);
		addBoardPattern(getElementList(Element.A), 1, 3);
		addBoardPattern(getElementList(Element.B), 1, 4);
		addBoardPattern(getElementList(Element.A), 1, 7);
		addBoardPattern(getElementList(Element.B), 0, 1, 3);
		addBoardPattern(getElementList(Element.A, Element.B), 0, 1, 4);
		addBoardPattern(getElementList(Element.D), 0, 1, 5);
		addBoardPattern(getElementList(Element.A), 0, 1, 6);
		addBoardPattern(getElementList(Element.D), 0, 1, 7);
		addBoardPattern(getElementList(Element.D), 0, 1, 8);
		addBoardPattern(getElementList(Element.A), 0, 2, 4);
		addBoardPattern(getElementList(Element.A, Element.B), 0, 2, 6);
		addBoardPattern(getElementList(Element.A), 0, 2, 7);
		addBoardPattern(getElementList(Element.A), 0, 4, 5);
		addBoardPattern(new ArrayList<>(), 0, 5, 7);
		addBoardPattern(getElementList(Element.A, Element.B), 1, 3, 4);
		addBoardPattern(getElementList(Element.B), 1, 3, 5);
		addBoardPattern(getElementList(Element.A), 0, 1, 3, 4);
		addBoardPattern(getElementList(Element.A), 0, 1, 3, 5);
		addBoardPattern(getElementList(Element.A), 0, 1, 3, 8);
		addBoardPattern(getElementList(Element.B), 0, 1, 4, 5);
		addBoardPattern(getElementList(Element.B), 0, 1, 4, 6);
		addBoardPattern(getElementList(Element.B), 0, 1, 5, 6);
		addBoardPattern(getElementList(Element.A, Element.B), 0, 1, 5, 7);
		addBoardPattern(getElementList(Element.A, Element.B), 0, 1, 5, 8);
		addBoardPattern(getElementList(Element.B), 0, 1, 6, 7);
		addBoardPattern(getElementList(Element.B), 0, 1, 6, 8);
		addBoardPattern(getElementList(Element.A), 0, 1, 7, 8);
		addBoardPattern(getElementList(Element.B), 0, 2, 4, 7);
		addBoardPattern(getElementList(Element.A), 0, 2, 6, 8);
		addBoardPattern(getElementList(Element.B), 0, 4, 5, 7);
		addBoardPattern(getElementList(Element.A), 1, 3, 5, 7);
		addBoardPattern(getElementList(Element.B), 0, 1, 3, 5, 7);
		addBoardPattern(getElementList(Element.B), 0, 1, 3, 5, 8);
		addBoardPattern(getElementList(Element.A), 0, 1, 4, 5, 6);
		addBoardPattern(getElementList(Element.A), 0, 1, 5, 6, 7);
		addBoardPattern(getElementList(Element.A), 0, 1, 5, 6, 8);
		addBoardPattern(getElementList(Element.A), 0, 1, 3, 5, 7, 8);

	}

	private void addBoardPattern(ArrayList<Element> elements,
			Integer... integers) {

		ArrayList<Integer> integersList = new ArrayList<>(integers);

		Board board = new Board();

		for (Integer integer : integersList)
			board.setNonEmpty(integer);

		this.boardPatterns.addEntry(board, elements);

	}

	private ArrayList<Element> getElementList(Element... elements) {

		ArrayList<Element> elementsList = new ArrayList<>(elements);
		return elementsList;

	}

	public ArrayList<Element> getElementList(Board boardOriginal) {
		return getElementList(boardOriginal, false);
	}

	private ArrayList<Element> getElementList(Board boardOriginal,
			boolean usedMirror) {

		Board boardClone = boardOriginal.clone();

		if (usedMirror)
			boardClone.mirror();

		for (Board boardTemp : this.boardPatterns.getKeys()) {

			for (int counter = 1; counter <= 4; counter++) {

				if (boardClone.equals(boardTemp))
					return this.boardPatterns.getValue(boardTemp);

				boardClone.rotate();

			}

		}

		if (!usedMirror)
			return getElementList(boardOriginal, true);
		else
			return new ArrayList<>();

	}

}

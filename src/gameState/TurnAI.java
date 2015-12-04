package gameState;

import javafx.scene.input.KeyCode;
import utils.ArrayList;
import board.Board;
import board.Box;
import enums.Element;
import enums.GameStateEnum;
import enums.TextEnum;

public class TurnAI extends GameState {

	private boolean executing = false;

	public TurnAI(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		this.executing = false;
		super.controller.textController().showText(TextEnum.PROCEED);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		if (this.executing)
			return;

		super.controller.textController().concealText();

		this.executing = true;

		handleAI();

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (this.executing)
			return;

		super.controller.textController().concealText();

		this.executing = true;

		handleAI();

	}

	private void handleAI() {

		ArrayList<Board> boards = super.controller.boardController()
				.getBoards();
		ArrayList<Element> elements = getBoardElementsTrimmed(boards);

		if (super.controller.elementController().isPerfectPosition(elements))
			handlePerfectPosition();
		else
			handleNonPerfectPosition();

	}

	private ArrayList<Element> getBoardElementsTrimmed(ArrayList<Board> boards) {

		ArrayList<Element> elements = new ArrayList<>();

		for (Board board : boards)
			elements.addAll(super.controller.boardPatternsController()
					.getElementList(board));

		elements = super.controller.elementController().trimElements(elements);

		return elements;

	}

	private void handlePerfectPosition() {

		ArrayList<Box> boxes = super.controller.boardController().getBoxes();

		while (true) {

			if (!boxes.isEmpty()) {

				Box box = boxes.removeRandom();
				Board board = box.getBoard();

				box.setNonEmpty();

				if (!board.isActive()) {
					box.setEmpty();

				} else {

					box.setEmpty();
					executeBox(box);
					break;

				}

			} else {

				boxes = super.controller.boardController().getBoxes();
				Box box = boxes.removeRandom();

				executeBox(box);
				break;

			}

		}

	}

	private void handleNonPerfectPosition() {

		ArrayList<Board> boards = super.controller.boardController()
				.getBoards();
		ArrayList<Box> boxesAll = super.controller.boardController().getBoxes();
		ArrayList<Box> boxesSettingPerfectPositionInactive = new ArrayList<>();

		while (!boxesAll.isEmpty()) {

			Box box = boxesAll.removeFirst();
			Board board = box.getBoard();

			box.setNonEmpty();

			ArrayList<Element> elements = getBoardElementsTrimmed(boards);

			box.setEmpty();

			if (super.controller.elementController()
					.isPerfectPosition(elements))

				if (!board.isActive()) {

					executeBox(box);
					return;

				} else
					boxesSettingPerfectPositionInactive.add(box);

		}

		executeBox(boxesSettingPerfectPositionInactive.getRandom());

	}

	private void executeBox(Box box) {

		Board board = box.getBoard();

		super.controller.boardController().setBoxNonEmpty(box);

		if (!board.isActive())
			super.controller.boardController().setBoardInactive(board);

		super.controller.flow().proceedToNextPhase();

	}

}

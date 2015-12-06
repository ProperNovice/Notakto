package gameState;

import javafx.scene.input.KeyCode;
import utils.ArrayList;
import board.Board;
import board.Box;
import enums.Element;
import enums.GameStateEnum;

public class SuggestMove extends GameState {

	private ArrayList<Box> boxesSuggested = new ArrayList<>();

	public SuggestMove(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		this.boxesSuggested.clear();

		ArrayList<Board> boards = super.controller.boardController()
				.getBoards();
		ArrayList<Box> boxesAll = super.controller.boardController().getBoxes();
		ArrayList<Box> boxesSettingPerfectPositionInactive = new ArrayList<>();
		ArrayList<Box> boxesSettingPerfectPositionActive = new ArrayList<>();

		while (!boxesAll.isEmpty()) {

			Box box = boxesAll.removeFirst();
			Board board = box.getBoard();

			box.setNonEmpty();

			ArrayList<Element> elements = getBoardElementsTrimmed(boards);

			box.setEmpty();

			if (super.controller.elementController()
					.isPerfectPosition(elements))

				if (!board.isActive())
					boxesSettingPerfectPositionInactive.add(box);

				else
					boxesSettingPerfectPositionActive.add(box);

		}

		if (!boxesSettingPerfectPositionInactive.isEmpty())
			this.boxesSuggested.addAll(boxesSettingPerfectPositionInactive);
		else
			this.boxesSuggested.addAll(boxesSettingPerfectPositionActive);

		for (Box box : this.boxesSuggested)
			box.setColorSuggested();

	}

	private ArrayList<Element> getBoardElementsTrimmed(ArrayList<Board> boards) {

		ArrayList<Element> elements = new ArrayList<>();

		for (Board board : boards)
			elements.addAll(super.controller.boardPatternsController()
					.getElementList(board));

		elements = super.controller.elementController().trimElements(elements);

		return elements;

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {
		proceed();
	}

	@Override
	public void handleBoxPressedPrimary(Box box, Board board) {
		proceed();
	}

	@Override
	protected void handleBoxNonEmptyPressed(Box box, Board board) {
		proceed();
	}

	private void proceed() {

		for (Box box : this.boxesSuggested)
			box.setColorEmpty();

		super.controller.flow().addGameStateFirst(GameStateEnum.TURN_HUMAN);
		super.controller.flow().proceedToNextPhase();

	}

}

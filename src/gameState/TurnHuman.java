package gameState;

import javafx.scene.input.KeyCode;
import utils.ArrayList;
import board.Board;
import board.Box;
import enums.Element;
import enums.GameStateEnum;
import enums.TextEnum;

public class TurnHuman extends GameState {

	public TurnHuman(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.playerController().setCurrentPlayerTextTurnVisible(
				true);
		super.controller.textController().showText(TextEnum.MAKE_A_MOVE);

	}

	@Override
	protected void handleBoxNonEmptyPressed(Box box, Board board) {

		super.controller.textController().concealText();
		super.controller.playerController().setCurrentPlayerTextTurnVisible(
				false);

		super.controller.boardController().setBoxNonEmpty(box);

		if (!board.isActive())
			super.controller.boardController().setBoardInactive(board);

		super.controller.flow().proceedToNextPhase();

	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (!keyCode.equals(KeyCode.S))
			return;

		ArrayList<Board> boards = super.controller.boardController()
				.getBoards();
		ArrayList<Element> elements = getBoardElementsTrimmed(boards);

		if (super.controller.elementController().isPerfectPosition(elements))
			return;

		super.controller.textController().concealText();
		super.controller.playerController().setCurrentPlayerTextTurnVisible(
				false);

		super.controller.flow().addGameStateFirst(GameStateEnum.SUGGEST_MOVE);
		super.controller.flow().proceedToNextPhase();

	}

	private ArrayList<Element> getBoardElementsTrimmed(ArrayList<Board> boards) {

		ArrayList<Element> elements = new ArrayList<>();

		for (Board board : boards)
			elements.addAll(super.controller.boardPatternsController()
					.getElementList(board));

		elements = super.controller.elementController().trimElements(elements);

		return elements;

	}

}

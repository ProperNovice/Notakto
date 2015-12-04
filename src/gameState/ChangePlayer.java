package gameState;

import utils.ArrayList;
import utils.Logger;
import board.Board;
import enums.Element;
import enums.GameStateEnum;

public class ChangePlayer extends GameState {

	public ChangePlayer(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		printBoards();
		
		super.controller.playerController().setCurrentPlayerTextVisible(false);

		super.controller.playerController().changePlayer();

		GameStateEnum gameStateEnum = super.controller.playerController()
				.getCurrentPlayerType();
		super.controller.flow().addGameStateFirst(gameStateEnum);
		super.controller.playerController().setCurrentPlayerTextVisible(true);

		super.controller.flow().proceedToNextPhase();

	}

	private void printBoards() {

		ArrayList<Board> boards = super.controller.boardController()
				.getBoards();

		for (Board board : boards)
			board.print();

		printBoardElementPosition();

	}

	private void printBoardElementPosition() {

		ArrayList<Board> boards = super.controller.boardController()
				.getBoards();
		ArrayList<Element> elements = new ArrayList<>();

		for (Board board : boards)
			elements.addAll(super.controller.boardPatternsController()
					.getElementList(board));

		elements = super.controller.elementController().trimElements(elements);

		Logger.log("board position is ");

		if (super.controller.elementController().isPerfectPosition(elements))
			Logger.logNewLine("perfect");
		else
			Logger.logNewLine("not perfect");

	}

}

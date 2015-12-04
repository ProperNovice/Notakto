package gameState;

import utils.ArrayList;
import utils.Logger;
import board.Board;
import enums.Element;
import enums.GameStateEnum;
import enums.PlayerType;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		printBoardElementPosition();

		// startGame(PlayerType.AI, PlayerType.HUMAN);
		// startGame(PlayerType.HUMAN, PlayerType.AI);
		// startGame(PlayerType.HUMAN, PlayerType.HUMAN);
		startGame(PlayerType.AI, PlayerType.AI);

		// testBoards();

	}

	private void startGame(PlayerType playerTypeI, PlayerType playerTypeII) {

		super.controller.playerController().setPlayers(playerTypeI,
				playerTypeII);

		GameStateEnum gameStateEnum = super.controller.playerController()
				.getCurrentPlayerType();
		super.controller.playerController().setCurrentPlayerTextTurnVisible(
				true);
		super.controller.flow().addGameStateFirst(gameStateEnum);

		super.controller.flow().proceedToNextPhase();

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

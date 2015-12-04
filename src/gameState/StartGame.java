package gameState;

import utils.ArrayList;
import utils.Logger;
import utils.ShutDown;
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

		startGame(PlayerType.HUMAN, PlayerType.AI);

//		testBoards();

	}

	private void startGame(PlayerType playerTypeI, PlayerType playerTypeII) {

		super.controller.playerController().setPlayers(PlayerType.HUMAN,
				PlayerType.HUMAN);

		GameStateEnum gameStateEnum = super.controller.playerController()
				.getCurrentPlayerType();
		super.controller.flow().addGameStateFirst(gameStateEnum);

		super.controller.flow().proceedToNextPhase();

	}

	private void testBoards() {

		int total = 0;
		int totalNonActive = 0;

		int a = -1, b = -1, c = -1, d = -1, e = -1, f = -1;

		Board board = new Board();

		for (a = 0; a < 9; a++)
			for (b = a + 1; b < 9; b++)
				for (c = b + 1; c < 9; c++)
					for (d = c + 1; d < 9; d++)
						for (e = d + 1; e < 9; e++)
							for (f = e + 1; f < 9; f++)

							{

								board.setAllEmpty();
								board.setNonEmpty(a, b, c, d, e, f);

								total++;

								if (!board.isActive())
									continue;

								totalNonActive++;

								ArrayList<Element> elementList = super.controller
										.boardPatternsController()
										.getElementList(board);

								if (elementList != null)
									continue;

								Logger.logNewLine("not found");
								ShutDown.execute();

							}

		System.out.println(totalNonActive + " active");
		System.out.println(total - totalNonActive + " nonActive");
		System.out.println(total + " total");

	}

}

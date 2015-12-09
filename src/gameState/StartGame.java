package gameState;

import utils.ArrayList;
import utils.Logger;
import utils.Serialization;
import utils.ShutDown;
import board.Board;
import controller.LastSettingsController;
import enums.Element;
import enums.GameStateEnum;
import enums.TextEnum;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		lastSettingsReadFromFile();

		super.controller.flow().addGameStateFirst(GameStateEnum.OPTIONS);
		super.controller.flow().proceedToNextPhase();

	}

	private void lastSettingsReadFromFile() {

		if (!Serialization.fileExists())
			return;

		Object object = Serialization.readFromFile();

		if (!(object instanceof LastSettingsController))
			return;

		LastSettingsController lastSettingsController = (LastSettingsController) object;

		int totalBoards = lastSettingsController.getTotalBoards();
		TextEnum playersEnum = lastSettingsController.getPlayersEnum();

		super.controller.lastSettingsController().setLastSettings(totalBoards,
				playersEnum);

	}

	public void testBoards() {

		// change BoardPatternsController.getElementList return to null

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

								board.print();

								Logger.logNewLine("not found");
								ShutDown.execute();

							}

		System.out.println(totalNonActive + " active");
		System.out.println(total - totalNonActive + " nonActive");
		System.out.println(total + " total");

	}

}

package gameState;

import utils.ArrayList;
import utils.Logger;
import utils.ShutDown;
import board.Board;
import board.Box;
import enums.Element;
import enums.GameStateEnum;

public class TurnHuman extends GameState {

	public TurnHuman(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

	}

	@Override
	protected void handleBoxNonEmptyPressed(Box box, Board board) {

		box.setNonEmpty();
		box.setRedX();

		board.print();

		if (!board.isActive()) {

			System.out.println("not active");
			return;

		}

		ArrayList<Element> elementList = super.controller
				.boardPatternsController().getElementList(board);

		if (elementList != null)
			elementList.printList();
		else {

			Logger.logNewLine("board not found");
			board.print();
			ShutDown.execute();

		}

	}

}

package gameState;

import board.Board;
import board.Box;
import enums.GameStateEnum;
import enums.TextEnum;

public class TurnHuman extends GameState {

	public TurnHuman(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.textController().showText(TextEnum.CONTINUE);

	}

	@Override
	protected void handleBoxNonEmptyPressed(Box box, Board board) {

		super.controller.boardController().setBoxNonEmpty(box);

		if (!board.isActive())
			super.controller.boardController().setBoardInactive(board);

	}

}

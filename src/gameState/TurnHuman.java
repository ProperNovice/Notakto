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

		super.controller.textController().showText(TextEnum.MAKE_A_MOVE);

	}

	@Override
	protected void handleBoxNonEmptyPressed(Box box, Board board) {

		super.controller.textController().concealText();
		super.controller.playerController().setCurrentPlayerTextVisible(false);

		super.controller.boardController().setBoxNonEmpty(box);

		if (!board.isActive())
			super.controller.boardController().setBoardInactive(board);

		super.controller.flow().proceedToNextPhase();

	}

}

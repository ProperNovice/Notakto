package gameState;

import board.Board;
import utils.ArrayList;
import enums.GameStateEnum;
import enums.TextEnum;

public class CheckIfGameEnded extends GameState {

	public CheckIfGameEnded(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		ArrayList<Board> boards = super.controller.boardController()
				.getBoards();

		if (boards.size() > 0)
			super.controller.flow().proceedToNextPhase();
		
		else {
			
			super.controller.playerController().setCurrentPlayerTextEndGameVisible();
			super.controller.textController().showText(TextEnum.RESTART);
			
		}

	}

}

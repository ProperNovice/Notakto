package gameState;

import instances.Instances;
import javafx.scene.input.KeyCode;
import utils.ArrayList;
import board.Board;
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

			super.controller.playerController()
					.setCurrentPlayerTextEndGameVisible();
			super.controller.textController().showText(TextEnum.RESTART);

		}

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {
		restart();
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {
		restart();
	}

	private void restart() {
		Instances.getPanelGameInstance().restartGame();
	}

}

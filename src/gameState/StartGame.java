package gameState;

import enums.GameStateEnum;
import enums.PlayerType;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		// startGame(PlayerType.AI, PlayerType.HUMAN);
		// startGame(PlayerType.HUMAN, PlayerType.AI);
		// startGame(PlayerType.HUMAN, PlayerType.HUMAN);
		startGame(PlayerType.AI, PlayerType.AI);

		// testBoards();

	}

	private void startGame(PlayerType playerTypeI, PlayerType playerTypeII) {

		super.controller.playerController().setPlayers(playerTypeI,
				playerTypeII);

		super.controller.flow().proceedToNextPhase();

	}

}

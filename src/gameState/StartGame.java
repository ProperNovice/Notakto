package gameState;

import enums.GameStateEnum;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		super.controller.flow().addGameStateFirst(GameStateEnum.OPTIONS);
		super.controller.flow().proceedToNextPhase();

	}

}
